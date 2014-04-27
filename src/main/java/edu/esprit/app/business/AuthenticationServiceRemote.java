package edu.esprit.app.business;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.app.persistence.User;

@Remote
public interface AuthenticationServiceRemote {
	void createUser(User user);

	List<User> findAllUsers();

	User authenticate(String login, String password);
}
