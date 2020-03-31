package br.cnec.ead.exemplojpa.test;
import java.math.BigDecimal;
import br.cnec.ead.exemplojpa.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
public class PersistindoVeiculo {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Volkswagen");
		veiculo.setModelo("Jetta");
		veiculo.setAnoFabricacao(2016);
		veiculo.setAnoModelo(2016);
		veiculo.setValor(new BigDecimal(76300));
		manager.persist(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
