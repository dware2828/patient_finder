package com.dware.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dware.demo.model.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String>{

	@Query("{'ssn':?0}")
	Optional<Patient> findPatientBySsn(String ssn);
}
