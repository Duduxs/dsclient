package com.edudev.dsclient.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edudev.dsclient.entities.Client;
import com.edudev.dsclient.repositories.ClientRepository;
import com.edudev.dsclient.services.exceptions.ResourceNotFound;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<Client> findAllPagination(PageRequest pageRequest){
		Page<Client> list = repository.findAll(pageRequest);
		return list;
	}
	
	@Transactional(readOnly = true)
	public Client findById(Long id){
		Optional<Client> client = repository.findById(id);
		return client.orElseThrow(() -> new ResourceNotFound("Resource not founded!"));
	}
}
