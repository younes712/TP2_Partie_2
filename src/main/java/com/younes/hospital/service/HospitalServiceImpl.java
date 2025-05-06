package com.younes.hospital.service;

import com.younes.hospital.entities.Consultation;
import com.younes.hospital.entities.Docteur;
import com.younes.hospital.entities.Patient;
import com.younes.hospital.entities.RendezVous;
import com.younes.hospital.repositories.ConsultationRepository;
import com.younes.hospital.repositories.DocteurRepository;
import com.younes.hospital.repositories.PatientRepository;
import com.younes.hospital.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private DocteurRepository docteurRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, DocteurRepository docteurRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.docteurRepository = docteurRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient save(Patient patient) {

        return patientRepository.save(patient);
    }

    @Override
    public Docteur save(Docteur docteur) {

        return docteurRepository.save(docteur);
    }

    @Override
    public RendezVous save(RendezVous rendezVous) {

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation save(Consultation consultation) {

        return consultationRepository.save(consultation);
    }
}
