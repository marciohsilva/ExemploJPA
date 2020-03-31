package br.cnec.ead.exemplojpa.test;
import java.math.BigDecimal;
import br.cnec.ead.exemplojpa.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
public class AtualizandoVeiculo {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		System.out.println("Valor atual: " + veiculo.getValor());
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(1500)));
		System.out.println("Novo valor: " + veiculo.getValor());
		tx.commit();
		manager.close();
		JpaUtil.close();
		}
}
