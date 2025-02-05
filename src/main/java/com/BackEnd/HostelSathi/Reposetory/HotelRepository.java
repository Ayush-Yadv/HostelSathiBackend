package com.BackEnd.HostelSathi.Reposetory;

import com.BackEnd.HostelSathi.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
