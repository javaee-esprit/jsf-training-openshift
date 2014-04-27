package edu.esprit.app.business;

import javax.ejb.Local;

import edu.esprit.app.persistence.Customer;

@Local
public interface CustomerServiceLocal {
	
	void saveOrUpdate(Customer customer);

}
