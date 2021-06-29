package com.dware.demo;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dware.demo.model.Patient;
import com.dware.demo.repository.PatientRepository;
import com.dware.demo.service.PatientService;




@ExtendWith(MockitoExtension.class)
class PatientFinderTestCases {

	@Mock
    private PatientRepository repository;
	
	@InjectMocks
    private PatientService service;
	
	private Patient patient;
	private Patient patient2;
	
	@BeforeEach
	void setUp() throws Exception {
		
		patient = new Patient();
		patient.setFirstName("Danny");
		patient.setLastName("Ware");
		patient.setPhoneNum("3304132546");
		patient.setEmail("dware2828@gmail.com");
		patient.setPatientId("2546321");
		patient.setSsn("2315288963");
		
		patient2 = new Patient();
		patient2.setFirstName("Danny");
		patient2.setLastName("Ware");
		patient2.setPhoneNum("3304132546");
		patient2.setEmail("dware2828@gmail.com");
		patient2.setPatientId("2546321");
		patient2.setSsn("2315288963");
		
	}
	
	
	@Test
	void AddNewPatientToLookUpTable() {
				
		service.addPatient(patient);
		
		verify(repository, times(1)).insert(any(Patient.class));
	}
	
	@Test
	void UpdatePatientInLookUpTable_RuntimeException() {
		
		when(repository.findById(patient.getPatientId())).thenReturn(null);
		
		assertThrows(RuntimeException.class, () -> {
			service.updatePatient(patient);
		  });
		
		verify(repository, times(1)).findById(patient.getPatientId());
	}
	
	@Test
	void UpdatePatientInLookUpTable() {
		
		when(repository.findById(patient.getPatientId())).thenReturn(Optional.of(patient));
		
		service.updatePatient(patient);
		
		verify(repository, times(1)).findById(patient.getPatientId());
		verify(repository, times(1)).save(patient);
	}
	
	@Test
	void getAllPatient() {
		
		List<Patient> patients = new ArrayList<Patient>();
		patients.add(patient);
		
		when(repository.findAll()).thenReturn(patients);
				
		Assertions.assertEquals(patients, service.getAllPatients());
		verify(repository, times(1)).findAll();
		
	}
	
	@Test
	void getPatientBySsn() {
		
		when(repository.findPatientBySsn(patient.getSsn())).thenReturn(Optional.of(patient));
				
		Assertions.assertEquals(patient, service.getPatientBySsn(patient.getSsn()));
		
		verify(repository, times(1)).findPatientBySsn(patient.getSsn());
	}
	

}
