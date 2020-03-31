package br.cnec.ead.exemplojpa.test;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.cnec.ead.exemplojpa.model.JpaUtil;
import br.cnec.ead.exemplojpa.model.Veiculo;
import br.cnec.ead.exemplojpa.model.Proprietario;
public class TestaPersistenciaCompleta {
	public static void main(String[] args) {
		boolean excluir = false;
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transacao1 = manager.getTransaction();
		transacao1.begin();
		// Incluindo proprietario 1
		Proprietario prop1 = new Proprietario();		
		prop1.setNome("Paulo Ricardo");
		prop1.setDocumento("CPF 897.789.789-00");
		manager.persist(prop1);
		// Incluindo proprietario 2
		Proprietario prop2 = new Proprietario();		
		prop2.setNome("Márcio Júnior");
		prop2.setDocumento("CPF 867.769.769-99");
		manager.persist(prop2);
		// Incluindo veículo 1
		Veiculo veiculo1 = new Veiculo();
		veiculo1.setFabricante("Nissan");
		veiculo1.setModelo("Sentra");
		veiculo1.setAnoFabricacao(2010);
		veiculo1.setAnoModelo(2010);
		veiculo1.setValor(new BigDecimal(30700));
		veiculo1.setProprietario(prop1);
		manager.persist(veiculo1);
		// Incluindo veículo 2
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setFabricante("Ford");
		veiculo2.setModelo("Focus");
		veiculo2.setAnoFabricacao(2018);
		veiculo2.setAnoModelo(2019);
		veiculo2.setValor(new BigDecimal(65000));
		veiculo2.setProprietario(prop2);
		manager.persist(veiculo2);		
		transacao1.commit();
		// Listando os veículos
		transacao1.begin();
		Query query = manager.createQuery("from Veiculo");
		List<Veiculo> veiculos = query.getResultList();
		for (Veiculo veiculo : veiculos) {
		   String dadosProp = "Sem proprietário";
		   if (veiculo.getProprietario() != null) {dadosProp = veiculo.getProprietario().getNome();}		   
		   System.out.println(veiculo.getDescricao() + " Prorietario: " + dadosProp);}
		transacao1.commit();
		// Excluindo os dados
		if (excluir==true) {
		   transacao1.begin();
		   Query querydel1 = manager.createQuery("delete from Veiculo");
		   Query querydel2 = manager.createQuery("delete from Proprietario");
		   querydel1.executeUpdate();
		   querydel2.executeUpdate();
		   transacao1.commit();
		}   
		manager.close();
		JpaUtil.close();
	}
}
