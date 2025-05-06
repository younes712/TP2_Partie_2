package com.younes.hospital.repositories;

import com.younes.hospital.entities.Docteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocteurRepository extends JpaRepository<Docteur, Long> {
    Docteur findByNom(String nom);
}
