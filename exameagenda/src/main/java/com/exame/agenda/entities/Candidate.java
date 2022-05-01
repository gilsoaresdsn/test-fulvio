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
import javax.persistence.OneToMany;
//import org.springframework.data.annotation.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Candidate")
public class Candidate implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	//Atencao a asssociacao de mao dupla - tratado com a anotacao @JsonIgnore
	//@JsonIgnore
	@OneToMany(mappedBy = "candidato")
	private List<Availability> exame = new ArrayList<>();

	public Candidate() {

	}

	public Candidate(Long id, String name, String email, String phone, String password) {
		super();

		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Availability> getExame() {
		return exame;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Candidate other = (Candidate) obj;
		return Objects.equals(id, other.id);
	}

	





}
