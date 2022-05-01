package com.exame.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.exame.agenda.repositories.RoomRepository;

import com.exame.agenda.entities.Room;

@Service //Registro de servico no mecanismo de injecao de independencia
public class RoomServices {
	@Autowired
	private RoomRepository repository;
	
	//Camada de servico para implemento do findAll
	public List<Room> findAll(){
		return repository.findAll();
	}
	
	public Room findById(Long id) {
		Optional<Room> obj = repository.findById(id);
		return obj.get();
	}
	
	
	

}
