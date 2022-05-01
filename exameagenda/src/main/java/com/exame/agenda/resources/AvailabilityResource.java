package com.exame.agenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exame.agenda.entities.Availability;
import com.exame.agenda.services.AvailabilityServices;


@RestController
@RequestMapping(value = "/availabilities") //Mapeamento para http://localhost:8080/candidates
public class AvailabilityResource {
	
	@Autowired  //injeta automaticamente
	private AvailabilityServices service;

	@GetMapping
	public ResponseEntity<List<Availability>> findAll(){
		
		//Availability disponivel = new Availability(1L, "10:00", Date(), candidate);
		
		List<Availability> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	//informa que a requisicao utilizara um ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Availability> findById(@PathVariable Long id) {
		Availability obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
	
}
