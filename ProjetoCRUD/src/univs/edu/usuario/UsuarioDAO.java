package univs.edu.usuario;

import static com.sun.jmx.mbeanserver.DefaultMXBeanMappingFactory.propertyName;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import univs.edu.util.HibernateUtil;

public class UsuarioDAO {
    private Session sessao;
    private Transaction transacao;
    
    
    public void salvar(Usuario usuario){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        if(usuario.getIdUsuario() == 0){
            sessao.save(usuario);
        }else{
            editar(usuario);
        }
        transacao.commit();
        sessao.close();
    }
    
    public void excluir(Usuario usuario){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(usuario);
        transacao.commit();
        sessao.close();
    }
    //update ou merge//
    public void editar(Usuario usuario){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.update(usuario); 
        transacao.commit();
        sessao.close();
    }
    
    public Usuario autenticarUsuario(String login, String senha){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("login", login)).add(Restrictions.eq("senha", senha)).uniqueResult();
        sessao.close();
        
        return usuario != null ? usuario : null;
    }
    
    public Usuario pesquisar(int id){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("idUsuario", id)).uniqueResult();
        sessao.close();
        return usuario;
    }
    
    public List<Usuario> ListarUsuarios(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Usuario> usuarios = sessao.createCriteria(Usuario.class).list();
        sessao.close();
        return usuarios;
    }
    
    public List<Usuario> pesquisar(String campo, String valor){
        sessao = HibernateUtil.
                getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Usuario> usuarios = sessao.
                createCriteria(Usuario.class).
                add(Restrictions.
                        ilike(campo, "%"+valor+"%")).list();
        sessao.close();
        return usuarios;
    }
    
}
