package br.cnec.ead.exemplojpa.test;
import javax.persistence.Persistence;
public class CriaTabelas {
	public static void main(String[] args) {		
			Persistence.createEntityManagerFactory("CnecPU");
	}
}