package br.cnec.ead.exemplojpa.test;
import br.cnec.ead.exemplojpa.model.*;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;
public class ListandoVeiculos {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Query query = manager.createQuery("from Veiculo");
		List<Veiculo> veiculos = query.getResultList();
		for (Veiculo veiculo : veiculos) {
		   String dadosProp = "Sem proprietário";
		   if (veiculo.getProprietario() != null) {dadosProp = veiculo.getProprietario().getNome();}		   
		   System.out.println(veiculo.getDescricao() + " Prorietario: " + dadosProp);		}
		manager.close();
		JpaUtil.close();
		}
}
