package edu.esprit.app.config;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.esprit.app.business.AuthenticationServiceLocal;
import edu.esprit.app.persistence.Admin;



@Singleton
@Startup
public class ConfigBean {
	
	@EJB
	private AuthenticationServiceLocal authentication;

    public ConfigBean() {
    }
    
    @PostConstruct
    public void createData(){
    	if (!authentication.loginExists("admin")) {
    		authentication.createUser(new Admin("admin", "admin", "company.esprit@gmail.com", 10));
		}
    }

}
