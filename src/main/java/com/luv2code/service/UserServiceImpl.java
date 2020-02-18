package com.luv2code.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.dao.RoleRepository;
import com.luv2code.dao.UserRepository;
import com.luv2code.entities.Role;
import com.luv2code.entities.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
		List<GrantedAuthority> springSecurityAuthorities = new ArrayList<>();
		for (Role r : roles) {
			springSecurityAuthorities.add(new SimpleGrantedAuthority(r.getRole()));
		}
		return springSecurityAuthorities;
	}

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		List<Role> rolesPersist = new ArrayList<>();
		for (Role role : user.getRoles()) {
			Role userRole = roleRepository.findByRole(role.getRole()).get(0);
			rolesPersist.add(userRole);
		}
		user.setRoles(rolesPersist);
		userRepository.save(user);
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleByName(String role) {
		return roleRepository.findByRole(role).get(0);
	}

	@Override
	public void cleanDataBase() {
		userRepository.deleteAll();
		roleRepository.deleteAll();
	}

	@Override
	public User getUserByUsername(String Name) {
		return userRepository.findByUsername(Name);
	}

	@Override
	public User getConnectedUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return getUserByUsername(auth.getName());
	}

	@Override
	public void delete(Long id) {
		
		userRepository.deleteById(id);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public List<User> getUserContains(String Name) {
		return userRepository.findByUsernameContaining(Name);
	}
/*
	@Override
	public List<User> getUserByRoles(List<Role> Role) {
		
		return userRepository.findUserByRoles(Role);
	}
*/

	@Override
	public boolean CompareUserWithAllUsers(User user) {
		
		List<User> listUsers= getAllUsers();
    	boolean UserExist= false;
    	
		for(User Utilisateur : listUsers) 
    	{
    		if (Utilisateur.getUsername().compareToIgnoreCase(user.getUsername())==0)
    			UserExist=true;
    		
    	}
    	
    	
    	return UserExist;
    	
	}
	
}