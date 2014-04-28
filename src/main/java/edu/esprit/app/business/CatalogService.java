package edu.esprit.app.business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.app.persistence.Category;
import edu.esprit.app.persistence.Product;

@Stateless
public class CatalogService implements CatalogServiceRemote,
		CatalogServiceLocal {

	@PersistenceContext
	private EntityManager em;

	public CatalogService() {
	}

	public void createProduct(Product product) {
		em.persist(product);
	}

	public void saveOrUpdateProduct(Product product) {
		em.merge(product);
	}

	public Product findProductById(int id) {
		return em.find(Product.class, id);
	}

	public void removeProduct(Product product) {
		em.remove(em.merge(product));
	}

	public List<Product> findAllProducts() {
		return em.createQuery("select p from Product p").getResultList();
	}

	public List<Product> findProductsByCategory(Category category) {
		return em.createQuery("select p from Product p where p.category=:c")
				.setParameter("c", category).getResultList();
	}

	public void createCategory(Category category) {
		em.persist(category);
	}

	public void saveOrUpdateCategory(Category category) {
		em.merge(category);
	}

	public Category findCategoryById(int id) {
		return em.find(Category.class, id);
	}

	public void removeCategory(Category category) {
		em.remove(em.merge(category));
	}

	public List<Category> findAllCategories() {
		return em.createQuery("select c from Category c").getResultList();
	}
	public Category findCategoryByName(String name) {
		Category found = null;
		Query query = em.createQuery("select c from Category c where c.name=:x");
		query.setParameter("x", name);
		try{
			found = (Category) query.getSingleResult();
		}catch(Exception ex){
			Logger.getLogger(this.getClass().getName()).log(Level.INFO, "no category with name="+name);
		}
		return found;
	}

}
