package com.mjm.patientscheduling;

import com.mjm.patientscheduling.entities.Appointment;
import com.mjm.patientscheduling.entities.Doctor;
import com.mjm.patientscheduling.entities.Insurance;
import com.mjm.patientscheduling.entities.Patient;
import com.mjm.patientscheduling.repos.AppointmentRepository;
import com.mjm.patientscheduling.repos.DoctorRepository;
import com.mjm.patientscheduling.repos.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientschedulingApplicationTests {

	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateDoctor(){
		Doctor doctor = new Doctor();
		doctor.setFirstName("Mark");
		doctor.setLastName("Case");
		doctor.setSpeciality("All");
		doctorRepository.save(doctor);
	}

	@Test
	public void testCreatePaitient(){
		Patient patient = new Patient();
		patient.setFirstName("Doug");
		patient.setLastName("Bailey");
		patient.setPhone("12345");

		Insurance insurance = new Insurance();
		insurance.setProviderName("BCBS");
		insurance.setCopay(20.00);

		Doctor doctor1 = doctorRepository.findOne(1);
		Doctor doctor2 = doctorRepository.findOne(2);
		List<Doctor> doctors = Arrays.asList(doctor1,doctor2);
		patient.setDoctors(doctors);

		patient.setInsurance(insurance);

		patientRepository.save(patient);
	}

	@Test
	public void testCreateAppointment(){
		Appointment appointment = new Appointment();

		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime);
		appointment.setReason("I have a problem");
		appointment.setStarted(true);
		appointment.setPatient(patientRepository.findOne(1));
		appointment.setDoctor(doctorRepository.findOne(1));
		appointmentRepository.save(appointment);
	}
}
