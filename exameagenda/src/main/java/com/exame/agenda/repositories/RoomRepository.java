package com.exame.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exame.agenda.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

}
