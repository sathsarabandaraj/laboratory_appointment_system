package com.las.laboratory_appointment_system.service.implementation;

import com.las.laboratory_appointment_system.dto.AppointmentListViewDto;
import com.las.laboratory_appointment_system.mapper.AppointmentMapper;
import com.las.laboratory_appointment_system.model.Appointment;
import com.las.laboratory_appointment_system.repository.AppointmentRepository;
import com.las.laboratory_appointment_system.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.las.laboratory_appointment_system.mapper.AppointmentMapper.mapObjToAppointmentListViewDto;


@Service
public class AppointmentServiceImplementation implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImplementation(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<AppointmentListViewDto> getAllAppointments() {
        List<Object[]> appointmentData = appointmentRepository.sa();

        for (Object[] objArray : appointmentData) {
            for (Object obj : objArray) {
                System.out.print(obj + " ");
            }
            System.out.println();
        }

        return mapObjToAppointmentListViewDto(appointmentData);
    }

    public Appointment getAppointmentById(int id) {
        return appointmentRepository.findById(id).get();
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
