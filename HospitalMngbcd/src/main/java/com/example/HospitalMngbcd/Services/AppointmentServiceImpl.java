package com.example.HospitalMngbcd.Services;
import com.example.HospitalMngbcd.Entities.AppointmentEntity;
import com.example.HospitalMngbcd.Models.Appointment;
import com.example.HospitalMngbcd.Repository.AppointmentRepository;
import com.example.HospitalMngbcd.exceptionHandler.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public String createAppointment(Appointment appointment) {
        AppointmentEntity appointmentEntity=new AppointmentEntity();
        BeanUtils.copyProperties(appointment,appointmentEntity);
        appointmentRepository.save(appointmentEntity);
        return "Appointment allotted successfully";
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<AppointmentEntity> appointmentEntities=appointmentRepository.findAll();
        if(appointmentEntities.isEmpty()){
            throw new ResourceNotFoundException("No appointments scheduled");
        }
        List<Appointment> appointments=new ArrayList<>();
        for (AppointmentEntity appointmentEntity:appointmentEntities){
            Appointment appointment=new Appointment();
            BeanUtils.copyProperties(appointmentEntity,appointment);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        AppointmentEntity appointmentEntity=appointmentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No appointment scheduled"));
        Appointment appointment=new Appointment();
        BeanUtils.copyProperties(appointmentEntity,appointment);

        return appointment;
    }

    @Override
    public String deleteAppointment(Long id) {
        AppointmentEntity appointmentEntity=appointmentRepository.findById(id)

                .orElseThrow(()->new ResourceNotFoundException("No appointment scheduled"));
        appointmentRepository.delete(appointmentEntity);
        return "Appointment deleted Successfully";
    }

    @Override
    public String updateAppointment(Long id, Appointment appointment) {
        AppointmentEntity existingAppointment=appointmentRepository.findById(id)

                .orElseThrow(()->new ResourceNotFoundException("No appointment scheduled"));
        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existingAppointment.setDescription(appointment.getDescription());
        existingAppointment.setStatus(appointment.getStatus());
        existingAppointment.setDoctorName(appointment.getDoctorName());
        existingAppointment.setPatientName(appointment.getPatientName());
        appointmentRepository.save(existingAppointment);
        return "Appointment Updated !";
    }
}

