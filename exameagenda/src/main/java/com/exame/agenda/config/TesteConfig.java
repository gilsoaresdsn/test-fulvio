package com.exame.agenda.config;



import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exame.agenda.entities.Availability;
import com.exame.agenda.entities.Candidate;
import com.exame.agenda.entities.Room;
import com.exame.agenda.repositories.AvailabiltyRepository;
import com.exame.agenda.repositories.CandidaterRepository;
import com.exame.agenda.repositories.RoomRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	@Autowired //O Spring resolve a dependencia e associa a CandidaterRepository
	private CandidaterRepository candidaterRepository;
	
	@Autowired
	private AvailabiltyRepository availabiltyRepository; 
	
	@Autowired
	private RoomRepository roomRepository; 
	
	
	

	@Override
	public void run(String... args) throws Exception {
		// Quando o programa for iniciado...
		
		Candidate c1 = new Candidate(null, "Gil Soares", "gil@gmail.com", "988888888", "123456"); 
		Candidate c2 = new Candidate(null, "Jacque", "jacque@gmail.com", "977777777", "123456");
		
		Room r1 = new Room(null, "001");
		Room r2 = new Room(null, "002");
		
		
		//Note a associaacao dos objetos "1 para N" - Um candidato pode selecionar varias datas disponiveis para o exame
		//possibilitando realizar qualquer exame em dias diferentes
		Availability a1 = new Availability(null, "", Instant.parse("2022-06-20T19:53:07Z"), c1, r1); 
		Availability a2 = new Availability(null, "", Instant.parse("2022-07-21T03:42:10Z"), c2, r1);
		Availability a3 = new Availability(null, "", Instant.parse("2022-08-21T03:42:10Z"), c2, r2);
		
		candidaterRepository.saveAll(Arrays.asList(c1,c2));
		roomRepository.saveAll(Arrays.asList(r1,r2));
		availabiltyRepository.saveAll(Arrays.asList(a1,a2, a3));
		
		//availabiltyRepository.delete(a3);
		
		
	}

}
