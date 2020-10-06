package com.edudev.dsclient.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.edudev.dsclient.entities.Client;
import com.edudev.dsclient.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional
	public Page<Client> findAllPagination(PageRequest pageRequest){
		Page<Client> list = repository.findAll(pageRequest);
		return list;
	}
}
