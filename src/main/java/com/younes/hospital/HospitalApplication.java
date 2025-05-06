package com.younes.hospital;

import com.younes.hospital.entities.*;
import com.younes.hospital.repositories.ConsultationRepository;
import com.younes.hospital.repositories.DocteurRepository;
import com.younes.hospital.repositories.PatientRepository;
import com.younes.hospital.repositories.RendezVousRepository;
import com.younes.hospital.service.HospitalServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner  start(HospitalServiceImpl hospitalService,
                             PatientRepository patientRepository,
                             DocteurRepository docteurRepository,
                             RendezVousRepository rendezVousRepository,
                             ConsultationRepository consultationRepository, HospitalServiceImpl hospitalServiceImpl) {
        return args -> {
            Stream.of("Mohamed", "Imad", "Rachid", "Fatah")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(true);
                        hospitalServiceImpl.save(patient);
                    });
            Stream.of(
                            new String[]{"Mohamed", "mohamed@hospital.com", "Cardiologie"},
                            new String[]{"Imad", "imad@hospital.com", "Neurologie"},
                            new String[]{"Rachid", "rachid@hospital.com", "Pédiatrie"},
                            new String[]{"Fatah", "fatah@hospital.com", "Chirurgie"}
                    )
                    .forEach(doctorData -> {
                        Docteur docteur = new Docteur();
                        docteur.setNom(doctorData[0]);
                        docteur.setEmail(doctorData[1]);
                        docteur.setSpecialite(doctorData[2]);
                        hospitalServiceImpl.save(docteur);
                    });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Docteur docteur = docteurRepository.findByNom("Imad");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setDocteur(docteur);
            rendezVous.setPatient(patient);
            rendezVous.setStatusRDV(StatusRDV.pending);
            hospitalServiceImpl.save(rendezVous);

            Consultation consultation = new Consultation();

            consultation.setDateConsultation(new Date());
            consultation.setRapport("Le rapport de la consultation numero 1");
            consultation.setRendezVous(rendezVous);
            hospitalService.save(consultation);
        };

    }
}
