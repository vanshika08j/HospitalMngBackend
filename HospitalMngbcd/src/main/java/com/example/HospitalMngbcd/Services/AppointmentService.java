package com.example.HospitalMngbcd.Services;


import com.example.HospitalMngbcd.Models.Appointment;

import java.util.List;

public interface AppointmentService {
    String createAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    String deleteAppointment(Long id);
    String updateAppointment(Long id, Appointment appointment);
}
