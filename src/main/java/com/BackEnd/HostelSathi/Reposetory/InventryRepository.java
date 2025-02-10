package com.BackEnd.HostelSathi.Reposetory;

import com.BackEnd.HostelSathi.Entity.Inventory;
import com.BackEnd.HostelSathi.Entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface InventryRepository extends JpaRepository<Inventory,Long> {

    void deleteById(Long id);

    void deleteAfterDateAndRoom(LocalDate today, Rooms room);
}
