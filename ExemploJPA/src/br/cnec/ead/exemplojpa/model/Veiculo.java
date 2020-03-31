package br.cnec.ead.exemplojpa.model;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "tab_veiculo")
public class Veiculo {
    private Long codigo;
    private String fabricante;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private BigDecimal valor;
    private Proprietario proprietario;
    private Date ultimaAtualizacao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_ultima_atualizacao", nullable = true)
    public Date getUltimaAtualizacao() {return ultimaAtualizacao;}
	public void setUltimaAtualizacao(Date ultimaAtualizacao) {this.ultimaAtualizacao = ultimaAtualizacao;}
	@OneToOne
    public Proprietario getProprietario() {return proprietario;}
	public void setProprietario(Proprietario proprietario) {this.proprietario = proprietario;}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }
    @Column(length = 60, nullable = false)
    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    public String getModelo() {  return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    @Column(name = "ano_fabricacao", nullable = false)
    public Integer getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(Integer anoFabricacao) { this.anoFabricacao = anoFabricacao; }
    @Column(name = "ano_modelo", nullable = false)
    public Integer getAnoModelo() { return anoModelo; }
    public void setAnoModelo(Integer anoModelo) { this.anoModelo = anoModelo; }
    @Column(precision = 10, scale = 2, nullable = true)
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor;}
    @Transient
    public String getDescricao() {
       return this.getFabricante() + " " + this.getModelo()
       + " " + this.getAnoFabricacao() + "/" + this.getAnoModelo()
       + " R$ " + this.getValor();
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final Veiculo other = (Veiculo)obj;
		if (codigo == null) {
		   if (other.codigo != null) return false;
		} else if (!codigo.equals(other.codigo))  return false;
		return true;
	}
	@Override
	public int hashCode() {
		  final int prime = 31;
		  int result = 1;
		  result = prime * result + ((codigo == null) ? 0 : codigo.hashCode()); return result;
	}
}
