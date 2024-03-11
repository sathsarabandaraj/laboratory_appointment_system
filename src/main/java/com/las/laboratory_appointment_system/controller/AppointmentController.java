package com.las.laboratory_appointment_system.controller;

import com.las.laboratory_appointment_system.dto.AppointmentListViewDto;
import com.las.laboratory_appointment_system.service.AppointmentService;
import com.las.laboratory_appointment_system.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService, PatientService patientService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        List<AppointmentListViewDto> appointmentListViewDtos = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointmentListViewDtos);
        return "appointment/appointments-list";
    }
}
