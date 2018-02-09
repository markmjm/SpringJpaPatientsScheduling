package com.mjm.patientscheduling.repos;

import com.mjm.patientscheduling.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer>{
}
