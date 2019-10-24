package univs.edu.usuario;

public class Main {
    
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        
        
        UsuarioDAO dao = new UsuarioDAO();
        
        
        usuario = dao.pesquisar(1);
        
        usuario.setLogin("Admin2");
        usuario.setSenha("TripaChico");
        
        dao.editar(usuario);            
        
        
        
        
        
        
        System.out.println(usuario.getIdUsuario());
        System.out.println(usuario.getLogin());
        System.out.println(usuario.getSenha());
    }
    
    
}
