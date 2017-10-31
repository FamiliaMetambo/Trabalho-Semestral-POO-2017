package Model;
// Generated Oct 8, 2017 3:40:37 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Servicos generated by hbm2java
 */
@Entity
@Table(name="servicos"
    ,catalog="sgps"
)
public class Servicos  implements java.io.Serializable {


     private Integer idServicos;
     private String nomeDoServico;
     private Set<Contratos> contratoses = new HashSet<Contratos>(0);
     private Set<Pacote> pacotes = new HashSet<Pacote>(0);

    public Servicos() {
    }

	
    public Servicos(String nomeDoServico) {
        this.nomeDoServico = nomeDoServico;
    }
    public Servicos(String nomeDoServico, Set<Contratos> contratoses, Set<Pacote> pacotes) {
       this.nomeDoServico = nomeDoServico;
       this.contratoses = contratoses;
       this.pacotes = pacotes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idServicos", unique=true, nullable=false)
    public Integer getIdServicos() {
        return this.idServicos;
    }
    
    public void setIdServicos(Integer idServicos) {
        this.idServicos = idServicos;
    }

    
    @Column(name="NomeDoServico", nullable=false, length=100)
    public String getNomeDoServico() {
        return this.nomeDoServico;
    }
    
    public void setNomeDoServico(String nomeDoServico) {
        this.nomeDoServico = nomeDoServico;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="servicos")
    public Set<Contratos> getContratoses() {
        return this.contratoses;
    }
    
    public void setContratoses(Set<Contratos> contratoses) {
        this.contratoses = contratoses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="servicos")
    public Set<Pacote> getPacotes() {
        return this.pacotes;
    }
    
    public void setPacotes(Set<Pacote> pacotes) {
        this.pacotes = pacotes;
    }




}


