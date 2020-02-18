package com.luv2code.service;

import java.util.List;

import com.luv2code.entities.Client;

public interface IClientService {

	List<Client> GetAllClients();
	void save(Client client);
	void delete(Long id);
	Client getClientById(Long id);
	List<Client> getClientsContains(String name);
	
}
