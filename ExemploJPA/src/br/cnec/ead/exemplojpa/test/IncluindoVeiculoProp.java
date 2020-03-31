package br.cnec.ead.exemplojpa.test;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import br.cnec.ead.exemplojpa.model.JpaUtil;
import br.cnec.ead.exemplojpa.model.Veiculo;
import br.cnec.ead.exemplojpa.model.Proprietario;
public class IncluindoVeiculoProp {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		// Criando o proprietario
		Proprietario prop1 = new Proprietario();		
		prop1.setNome("Paulo Ricardo");
		prop1.setDocumento("CPF 897.789.789-00");
		manager.persist(prop1);
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Nissan");
		veiculo.setModelo("Sentra");
		veiculo.setAnoFabricacao(2015);
		veiculo.setAnoModelo(2016);
		veiculo.setValor(new BigDecimal(53000));
		veiculo.setProprietario(prop1);
		manager.persist(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
