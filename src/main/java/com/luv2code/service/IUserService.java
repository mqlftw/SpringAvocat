package com.luv2code.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.luv2code.entities.Role;
import com.luv2code.entities.User;

public interface IUserService extends UserDetailsService{
	void save(User user);
	void save(Role role);
	List<User> getAllUsers();
	List<Role> getAllRoles();
	Role getRoleByName(String role);
	User getUserByUsername(String Name);
	//List<User> getUserByRoles(List<Role> Role);
	//User getUserByRole(String role);
	List<User> getUserContains(String Name);
	User getUserById(Long id);
	User getConnectedUser();
	boolean CompareUserWithAllUsers(User user);
	void cleanDataBase();
	void delete(Long id);
}
