package edu.esprit.app.business;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.app.persistence.Category;
import edu.esprit.app.persistence.Product;

@Local
public interface CatalogServiceLocal {
	void createProduct(Product product);
	void saveOrUpdateProduct(Product product);
	Product findProductById(int id);
	void removeProduct(Product product);
	List<Product> findAllProducts();
	
	List<Product> findProductsByCategory(Category category);
	
	
	void createCategory(Category category);
	void saveOrUpdateCategory(Category category);
	Category findCategoryById(int id);
	void removeCategory(Category category);
	List<Category> findAllCategories();
	
	Category findCategoryByName(String name);
	byte[] findPictureByProductId(int productId);
}
