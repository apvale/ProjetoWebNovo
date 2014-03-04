package dao;

import javax.persistence.Query;

import model.Pagamento;
import model.Usuario;

public class DAOPagamento extends DAOJPA<Pagamento>{
	
	public DAOPagamento(){
		super();
	}
	
	public Pagamento findByApto(String apto) {
		try {
			Query q = getManager().createQuery(
					"SELECT u FROM Usuario u WHERE u.usuario=?1");
			q.setParameter(1, apto);
			return (Pagamento) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
}


