package papeleria.controladores;

import javax.persistence.EntityManager;

import papeleria.model.Articulo;

public class ControladorArticulo extends SuperControladorJPA {

	private static ControladorArticulo instance = null;
	
	/**
	 * 
	 */
	public ControladorArticulo() {
		super("articulo", Articulo.class);
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorArticulo getInstance() {
		if (instance == null) {
			instance = new ControladorArticulo();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param a
	 */
	public void insertArticulo(Articulo a) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param a
	 */
	public void updateArticulo(Articulo a) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param id
	 */
	public void deleteArticulo(int id) {
		EntityManager em = getEntityManager();
		
		Articulo a = (Articulo) findById(id);
		
		em.getTransaction().begin();
		// Volvemos a enlazar nuestra entidad con nuestro manager.
		a = em.merge(a);
		em.remove(a);
		em.getTransaction().commit();
	}

}
