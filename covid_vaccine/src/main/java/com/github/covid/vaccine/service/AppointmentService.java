package com.github.covid.vaccine.service;

import java.util.List;

import javax.transaction.Transactional;

import com.github.covid.vaccine.model.Appointment;
import com.github.covid.vaccine.model.Patient;
import com.github.covid.vaccine.repository.AppointmentsRepository;
import com.github.covid.vaccine.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentsRepository aRepository;
    @Autowired
    private PatientRepository pRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment) {
        return aRepository.save(appointment);
    }

    public List<Appointment> createAppointments(List<Appointment> appointments) {
        return aRepository.saveAll(appointments);
    }

    public List<Appointment> getAppointments() {
        return aRepository.findAll();
    }

    public String cancelAppointment(int id) {
        aRepository.deleteById(id);
        return "Appoint with ID: " + id + " has been removed";
    }

    public Appointment updateAppointment(Integer patId, Integer aptId) {
        Patient patient = pRepository.findById(patId).get();

        return aRepository.findById(aptId).map(appointment -> {
            appointment.setPatient(patient);
            return aRepository.save(appointment);
        }).orElseGet(() -> {
            return null;
        });
    }

    public Appointment removePatientFromAppt(Integer apptId) {

        System.out.println("ENTERED REMOVE APPOINTMENT METHOD");

        return aRepository.findById(apptId).map(appointment -> {
            appointment.setPatient(null);
            return aRepository.save(appointment);
        }).orElseGet(() -> {
            return null;
        });
    }
}
