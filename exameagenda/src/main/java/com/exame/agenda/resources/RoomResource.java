package com.exame.agenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exame.agenda.entities.Room;
import com.exame.agenda.services.RoomServices;


@RestController
@RequestMapping(value = "/rooms") //Mapeamento para http://localhost:8080/rooms
public class RoomResource {
	
	@Autowired  //injeta automaticamente
	private RoomServices service;

	@GetMapping
	public ResponseEntity<List<Room>> findAll(){
		
		//Room r = new Room(1L, "001");
		
		List<Room> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	//informa que a requisicao utilizara um ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Room> findById(@PathVariable Long id) {
		Room obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
	
}
