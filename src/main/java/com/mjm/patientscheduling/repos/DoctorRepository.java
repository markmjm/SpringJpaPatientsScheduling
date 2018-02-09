package com.mjm.patientscheduling.repos;

import com.mjm.patientscheduling.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
