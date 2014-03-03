package dao;

import javax.persistence.Query;

import model.Administrador;


public class DAOAdministrador extends DAOJPA<Administrador>{

	public DAOAdministrador(){
		super();
	}
	
	public Administrador findByEmail(String email){
		try {
			Query q = getManager().createQuery("SELECT c FROM usuario_administrador c WHERE c.email=?1");
			q.setParameter(1, email);
			return (Administrador) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
