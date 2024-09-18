package com.example.HospitalMngbcd.Controllers;

import com.example.HospitalMngbcd.Models.Appointment;
import com.example.HospitalMngbcd.Services.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Frontend URL
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/appointments")
    public String scheduleAppointment(@Valid @RequestBody Appointment appointment){
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/appointments/{id}")
    public Appointment getAppointById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("/appointments/{id}")
    public String updateAppoint(@PathVariable Long id,@RequestBody Appointment appointment){
        return appointmentService.updateAppointment(id,appointment);
    }

    @DeleteMapping("/appointments/{id}")
    public String deleteAppoint(@PathVariable Long id){
        return appointmentService.deleteAppointment(id);
    }

}
