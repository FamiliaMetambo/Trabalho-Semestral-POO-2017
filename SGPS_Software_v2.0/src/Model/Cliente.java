package Model;



import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name="cliente"
    ,catalog="sgps"
)
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private String nome;
     private String morada;
     private String celular;
     private String email;
     private String tipocliente;
     private Date datareg;
     private String tipodoc;
     private String servico;
     private String pacote;
     private Set<Contratos> contratoses = new HashSet<Contratos>(0);

    public Cliente() {
    }

    public Cliente(String nome, String morada, String celular, String email, String tipocliente, Date datareg, String tipodoc) {
        this.nome = nome;
        this.morada = morada;
        this.celular = celular;
        this.email = email;
        this.tipocliente = tipocliente;
        this.datareg = datareg;
        this.tipodoc = tipodoc;
    }

    
    public Cliente(String nome, String morada, String celular, String email, String tipocliente, Date datareg, String tipodoc, String servico, String pacote, Set<Contratos> contratoses) {
       this.nome = nome;
       this.morada = morada;
       this.celular = celular;
       this.email = email;
       this.tipocliente = tipocliente;
       this.datareg = datareg;
       this.tipodoc = tipodoc;
       this.servico = servico;
       this.pacote = pacote;
       this.contratoses = contratoses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCliente", unique=true, nullable=false)
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    
    @Column(name="nome", length=45)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="morada", length=45)
    public String getMorada() {
        return this.morada;
    }
    
    public void setMorada(String morada) {
        this.morada = morada;
    }

    
    @Column(name="celular", length=45)
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    @Column(name="email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="tipocliente", length=45)
    public String getTipocliente() {
        return this.tipocliente;
    }
    
    public void setTipocliente(String tipocliente) {
        this.tipocliente = tipocliente;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datareg", length=10)
    public Date getDatareg() {
        return this.datareg;
    }
    
    public void setDatareg(Date datareg) {
        this.datareg = datareg;
    }

    
    @Column(name="tipodoc", length=45)
    public String getTipodoc() {
        return this.tipodoc;
    }
    
    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    
    @Column(name="Servico", length=60)
    public String getServico() {
        return this.servico;
    }
    
    public void setServico(String servico) {
        this.servico = servico;
    }

    
    @Column(name="Pacote", length=60)
    public String getPacote() {
        return this.pacote;
    }
    
    public void setPacote(String pacote) {
        this.pacote = pacote;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<Contratos> getContratoses() {
        return this.contratoses;
    }
    
    public void setContratoses(Set<Contratos> contratoses) {
        this.contratoses = contratoses;
    }




}


