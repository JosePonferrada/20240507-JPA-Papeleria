package papeleria.controladores;

import javax.persistence.EntityManager;

import papeleria.entities.Proveedor;

public class ControladorProveedor extends SuperControladorJPA {

	private static ControladorProveedor instance = null;
	
	/**
	 * 
	 */
	public ControladorProveedor() {
		super("proveedor", Proveedor.class);
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorProveedor getInstance() {
		if (instance == null) {
			instance = new ControladorProveedor();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param p
	 */
	public void updateProveedor(Proveedor p) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}

}
