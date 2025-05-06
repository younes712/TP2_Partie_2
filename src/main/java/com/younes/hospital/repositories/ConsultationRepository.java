package com.younes.hospital.repositories;

import com.younes.hospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository  extends JpaRepository<Consultation, Long> {
}
