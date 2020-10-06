package com.edudev.dsclient.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edudev.dsclient.entities.Client;
import com.edudev.dsclient.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientResource {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<Page<Client>> findAllPagination(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "3") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Client> list = service.findAllPagination(pageRequest);

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		Client client = service.findById(id);
		return ResponseEntity.ok().body(client);
	}

}
