package com.las.laboratory_appointment_system.controller;

import com.las.laboratory_appointment_system.dto.AppointmentListViewDto;
import com.las.laboratory_appointment_system.dto.UserDropListDto;
import com.las.laboratory_appointment_system.model.Appointment;
import com.las.laboratory_appointment_system.model.Doctor;
import com.las.laboratory_appointment_system.service.AppointmentService;
import com.las.laboratory_appointment_system.service.DoctorService;
import com.las.laboratory_appointment_system.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    public AppointmentController(AppointmentService appointmentService, PatientService patientService, PatientService patientService1, DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService1;
        this.doctorService = doctorService;
    }

    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        List<AppointmentListViewDto> appointmentListViewDtos = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointmentListViewDtos);
        return "appointment/appointments-list";
    }

    @GetMapping("/appointments/new")
    public String createAppointments(Model model) {
        Appointment appointment = new Appointment();
        List<UserDropListDto> patientDropList = patientService.getDropList();
        List<UserDropListDto> doctorDropList = doctorService.getDropList();
        model.addAttribute("appointment", appointment);
        model.addAttribute("patients", patientDropList);
        model.addAttribute("doctors", doctorDropList);
        return "appointment/appointment-create";
    }

    @PostMapping("/appointments/new")
    public String saveDoctor(@ModelAttribute("appointment") Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments";
    }
}
