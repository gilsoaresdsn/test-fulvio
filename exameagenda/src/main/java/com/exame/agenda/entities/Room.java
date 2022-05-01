package com.exame.agenda.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.exame.agenda.entities.Availability;

@Entity
@Table(name="Room")
public class Room implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private String numberRoom;
	
	//Atencao a asssociacao de mao dupla - tratado com a anotacao @JsonIgnore
	//@JsonIgnore
	@OneToMany(mappedBy = "room")
	private List<Availability> rooms = new ArrayList<>();
	
	
	public Room() {
		
	}


	public Room(Long id, String numberRoom) {
		super();
		this.id = id;
		this.numberRoom = numberRoom;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumberRoom() {
		return numberRoom;
	}


	public void setNumberRoom(String numberRoom) {
		this.numberRoom = numberRoom;
	}
	
	public List<Availability> getRoom() {
		return rooms;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, numberRoom);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(id, other.id) && Objects.equals(numberRoom, other.numberRoom);
	}
	
	
	
	
	
	

}
