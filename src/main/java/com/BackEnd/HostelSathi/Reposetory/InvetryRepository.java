package com.BackEnd.HostelSathi.Reposetory;

import com.BackEnd.HostelSathi.Entity.Invetory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvetryRepository extends JpaRepository<Invetory,Long> {
}
