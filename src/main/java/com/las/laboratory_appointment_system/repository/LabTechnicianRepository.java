package com.las.laboratory_appointment_system.repository;

import com.las.laboratory_appointment_system.model.LabTechnician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface LabTechnicianRepository extends JpaRepository<LabTechnician, Long> {

}