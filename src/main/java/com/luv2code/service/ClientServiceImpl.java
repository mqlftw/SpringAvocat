package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.dao.ClientRepository;
import com.luv2code.entities.Client;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	ClientRepository clientRepo;
	
	@Override
	public List<Client> GetAllClients() {
		return clientRepo.findAll();
	}

	@Override
	public void save(Client client) {
		clientRepo.save(client);
	}

	@Override
	public void delete(Long id) {
		clientRepo.deleteById(id);
	}

	@Override
	public Client getClientById(Long id) {
		return clientRepo.getOne(id);
	}

	@Override
	public List<Client> getClientsContains(String name) {
		return clientRepo.findBynomClientContaining(name);
	}

}
