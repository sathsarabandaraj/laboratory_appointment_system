package com.las.laboratory_appointment_system.service;

import com.las.laboratory_appointment_system.dto.PatientDto;
import com.las.laboratory_appointment_system.model.Patient;

import java.util.List;

public interface PatientService {
    List<PatientDto> findAllPatients();

    Patient savePatient(Patient patient);

    PatientDto findPatientById(Long patientId);

    void updatePatient(PatientDto patient);

    void delete(Long patientId);

    List<PatientDto> searchPatients(String query);
}
