package com.exame.agenda.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
//import org.springframework.data.annotation.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Availability")
public class Availability implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private String hora;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data;
	
	//Atencao a associacao de mao dupla - tratado com a anotacao @JsonIgnore
	//Aqui demonstra 1 Candidato relacionado com N disponibilidades
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidato;
	
	
	//Associacao com a sala (Room)
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
	//Construtor padrao
	public Availability() {
		
	}

	public Availability(Long id, String hora, Instant data, Candidate candidato, Room room) {
		super();
		this.id = id;
		this.hora = hora;
		this.data = data;
		this.candidato = candidato;
		this.room = room;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String tpExam) {
		this.hora = tpExam;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Candidate getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidate candidato) {
		this.candidato = candidato;
	}
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id, hora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Availability other = (Availability) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id) && Objects.equals(hora, other.hora);
	}
	
	
	
	
	
	

}
