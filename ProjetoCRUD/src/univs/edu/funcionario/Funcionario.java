

package univs.edu.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import univs.edu.usuario.Usuario;

@Entity
public class Funcionario{
   
   @Id
   @GeneratedValue
   
   
   private int indFuncionario;
   
   @Column(length = 100, nullable = false)
   private String nomeFuncionario;
  
   @Column(length = 20, nullable = false)
   private String cargo;
   
   @Column(length = 20, nullable = false)
   private String cpf;
   
   @Column(length = 100, nullable = false)
   private double salario;

   @OneToOne
   private Usuario usuario;

    /**
     * @return the indFuncionario
     */
    public int getIndFuncionario() {
        return indFuncionario;
    }

    /**
     * @param indFuncionario the indFuncionario to set
     */
    public void setIndFuncionario(int indFuncionario) {
        this.indFuncionario = indFuncionario;
    }

    /**
     * @return the nomeFuncionario
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * @param nomeFuncionario the nomeFuncionario to set
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   

   
}

