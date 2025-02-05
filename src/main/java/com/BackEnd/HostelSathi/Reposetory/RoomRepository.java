package com.BackEnd.HostelSathi.Reposetory;

import com.BackEnd.HostelSathi.Entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Rooms, Long> {
}
