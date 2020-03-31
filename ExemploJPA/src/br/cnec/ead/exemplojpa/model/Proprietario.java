package br.cnec.ead.exemplojpa.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name = "tab_proprietario")
public class Proprietario {
	private Long codigo;
	private String nome;
	private String documento;
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	@Column(name = "cod_veiculo")
	public Long getCodigo() {return codigo;}
	@Column(nullable = false)
	public String getDocumento() {return documento;}
	@Column(length = 60, nullable = false)
	public String getNome() {return nome;}
	public void setCodigo(Long codigo) {this.codigo = codigo;}
	public void setDocumento(String documento) {this.documento = documento;}
	public void setNome(String nome) {this.nome = nome;}
}
