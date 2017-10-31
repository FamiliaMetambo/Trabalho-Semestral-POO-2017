package Model;
// Generated Oct 8, 2017 3:40:37 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Pacote generated by hbm2java
 */
@Entity
@Table(name="pacote"
    ,catalog="sgps"
)
public class Pacote  implements java.io.Serializable {


     private Integer idPacote;
     private Servicos servicos;
     private String nomeDoPacote;

    public Pacote() {
    }

    public Pacote(Servicos servicos, String nomeDoPacote) {
       this.servicos = servicos;
       this.nomeDoPacote = nomeDoPacote;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idPacote", unique=true, nullable=false)
    public Integer getIdPacote() {
        return this.idPacote;
    }
    
    public void setIdPacote(Integer idPacote) {
        this.idPacote = idPacote;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="servicos_idServicos", nullable=false)
    public Servicos getServicos() {
        return this.servicos;
    }
    
    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    
    @Column(name="NomeDoPacote", nullable=false, length=50)
    public String getNomeDoPacote() {
        return this.nomeDoPacote;
    }
    
    public void setNomeDoPacote(String nomeDoPacote) {
        this.nomeDoPacote = nomeDoPacote;
    }




}

