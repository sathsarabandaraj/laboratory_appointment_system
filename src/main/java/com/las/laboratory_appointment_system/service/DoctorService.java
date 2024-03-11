package com.las.laboratory_appointment_system.service;

import com.las.laboratory_appointment_system.dto.DoctorDto;
import com.las.laboratory_appointment_system.model.Doctor;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> findAllDoctors();

    Doctor saveDoctor(Doctor doctor);

    DoctorDto findDoctorById(Long doctorId);

    void updateDoctor(DoctorDto doctor);

    void delete(Long doctorId);

    List<DoctorDto> searchDoctors(String query);
}
