package edu.esprit.app.web.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.esprit.app.business.AuthenticationServiceLocal;
import edu.esprit.app.persistence.Admin;
import edu.esprit.app.persistence.Customer;
import edu.esprit.app.persistence.User;

@ManagedBean(name="authBean")
@SessionScoped
public class AuthenticationBean implements Serializable{
	
	private static final long serialVersionUID = -6916676537171647179L;
	
	@EJB
	private AuthenticationServiceLocal authenticationServiceLocal;
	
	//our model
	private User user;
	//
	
	public AuthenticationBean() {
	}
	
	@PostConstruct
	public void init(){
		user = new User();
	}
	
	public String doLogin(){
		String navigateTo = null;
		User found = authenticationServiceLocal.authenticate(user.getLogin(), user.getPassword());
		if (found != null) {
			user = found;
			if(user instanceof Admin){
				navigateTo = "/pages/admin/home?faces-redirect=true";
			}
			if(user instanceof Customer){
				navigateTo = "/pages/customer/home?faces-redirect=true";
			}
		}else {
			navigateTo = "/pages/error?faces-redirect=true";
		}
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
