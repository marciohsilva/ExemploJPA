package br.cnec.ead.exemplojpa.model;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class JpaUtil {
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("CnecPU");
	}
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	public static void close() {
		factory.close();
	}

}
