package com.younes.hospital.service;

import com.younes.hospital.entities.Consultation;
import com.younes.hospital.entities.Docteur;
import com.younes.hospital.entities.Patient;
import com.younes.hospital.entities.RendezVous;

public interface IHospitalService  {
    Patient save(Patient patient);
    Docteur save(Docteur docteur);
    RendezVous save(RendezVous rendezVous);
    Consultation save(Consultation consultation);
}



