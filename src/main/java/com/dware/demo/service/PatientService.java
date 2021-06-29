package com.dware.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dware.demo.model.Patient;
import com.dware.demo.repository.PatientRepository;

@Service
public class PatientService {

	private PatientRepository patientRepository;
	
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	public void addPatient(Patient patient) {
		this.patientRepository.insert(patient);
	}
	
	public void updatePatient(Patient patient) {
		patientRepository.findById(patient.getPatientId()).orElseThrow(() -> new RuntimeException(
						String.format("Cannot Find Patient by %s", patient.getPatientId())));
		
		patientRepository.save(patient);

	}
	
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	
	public Patient getPatientBySsn(String ssn) {
		return patientRepository.findPatientBySsn(ssn).orElseThrow(() -> new RuntimeException(
				String.format("Cannot Find Patient by ssn %s", ssn)));
	}
	
	public void deletPatient(String id) {
		patientRepository.deleteById(id);
	}
}
