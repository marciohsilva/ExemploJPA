package br.cnec.ead.exemplojpa.test;
import br.cnec.ead.exemplojpa.model.Veiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import br.cnec.ead.exemplojpa.model.JpaUtil;
public class ExcluindoVeiculo {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		manager.remove(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}
}
