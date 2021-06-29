package com.dware.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dware.demo.model.Patient;
import com.dware.demo.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	public final PatientService patientService;
	
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		patientService.addPatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).build(); 
		
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> updatePatient(@RequestBody Patient patient) {
		patientService.updatePatient(patient);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Patient>> getAllPatients() {
		return ResponseEntity.ok(patientService.getAllPatients());
	}
	
	@GetMapping(path = "/{ssn}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Patient> getPatientbySsn(@PathVariable String ssn) {
		return ResponseEntity.ok(patientService.getPatientBySsn(ssn));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletPatient(@PathVariable String id) {
		patientService.deletPatient(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
