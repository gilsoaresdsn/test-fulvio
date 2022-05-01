package com.exame.agenda.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exame.agenda.entities.Candidate;
import com.exame.agenda.services.CandidateServices;


@RestController
@RequestMapping(value = "/candidates") //Mapeamento controlador rest para http://localhost:8080/candidates
public class CandidateResource {
	
	@Autowired  //injeta automaticamente
	private CandidateServices service;

	//Retorna todos os candidatos
	@GetMapping
	public ResponseEntity<List<Candidate>> findAll(){
		
		//Candidate usr = new Candidate(1L, "Gil Soares", "gilsoares@dsn", "9999999", "12345");
		
		List<Candidate> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	//Retorna o candidato pelo ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidate> findById(@PathVariable Long id) {
		Candidate obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Envio de dados, tratamento para Json através da anotacao @RequestBody
	@PostMapping
	public ResponseEntity<Candidate> insert(@RequestBody Candidate obj){
		obj = service.insert(obj);
		//return ResponseEntity.ok().body(obj);
		
		//Tratamento para o status de retorno 201 da pagina
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	//Deleta  dados pelo ID
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
}







































