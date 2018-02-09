package com.mjm.patientscheduling.repos;

import com.mjm.patientscheduling.entities.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment,Integer>{
}
