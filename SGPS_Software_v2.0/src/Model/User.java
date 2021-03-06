package Model;
// Generated Oct 8, 2017 3:40:37 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="sgps"
)
public class User  implements java.io.Serializable {


     private Integer idUser;
     private String password;
     private String nome;
     private String email;
     private String username;

    public User() {
    }

	
    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }
    public User(String password, String nome, String email, String username) {
       this.password = password;
       this.nome = nome;
       this.email = email;
       this.username = username;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idUser", unique=true, nullable=false)
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    
    @Column(name="password", nullable=false)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="nome")
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="username", nullable=false, length=200)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }




}


