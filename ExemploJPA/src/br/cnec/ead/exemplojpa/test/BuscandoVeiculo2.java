package br.cnec.ead.exemplojpa.test;
import br.cnec.ead.exemplojpa.model.*;
import javax.persistence.EntityManager;
public class BuscandoVeiculo2 {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
		System.out.println("Veículo de código: " + veiculo.getCodigo()
		+ " é um " + veiculo.getModelo());
		manager.close();
		JpaUtil.close();
	}
}
