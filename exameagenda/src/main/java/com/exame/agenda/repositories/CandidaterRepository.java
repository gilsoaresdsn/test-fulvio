package com.exame.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exame.agenda.entities.Candidate;

public interface CandidaterRepository extends JpaRepository<Candidate, Long>{

}
