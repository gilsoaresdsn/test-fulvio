package com.exame.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.exame.agenda.repositories.AvailabiltyRepository;

import com.exame.agenda.entities.Availability;

@Service //Registro de servico no mecanismo de injecao de independencia
public class AvailabilityServices {
	@Autowired
	private AvailabiltyRepository repository;
	
	//Camada de servico para implemento do findAll
	public List<Availability> findAll(){
		return repository.findAll();
	}
	
	public Availability findById(Long id) {
		Optional<Availability> obj = repository.findById(id);
		return obj.get();
	}
	
	
	

}
