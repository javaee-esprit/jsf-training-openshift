package edu.esprit.app.web.mbeans;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import edu.esprit.app.business.CatalogServiceLocal;
import edu.esprit.app.persistence.Category;



@ManagedBean
@ApplicationScoped
public class HelperBean {


	@EJB
	private CatalogServiceLocal catalog;

	public HelperBean() {
	}

	public Category findCategoryByName(String name) {
		return catalog.findCategoryByName(name);
	}

}
