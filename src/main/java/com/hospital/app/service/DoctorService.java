package com.hospital.app.service;


import com.hospital.app.model.Doctor;
import com.hospital.app.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    public Doctor getDoctorById(int id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> getDoctorsBySpecialtyId(int id) {
        return doctorRepository.findBySpecialtyId(id);
    }

    public List<Doctor> getDoctorsByName(String name) {
        return doctorRepository.findByDoctorName(name);
    }

    public List<Doctor> getDoctorsByNameAndSpecialtyId(String name, int id) {
        return doctorRepository.findByDoctorNameAndSpecialtyId(name, id);
    }

    public List<Doctor> saveAllDoctors(List<Doctor> doctors) {
        return (List<Doctor>) doctorRepository.saveAll(doctors);
    }

    public long countRows() {
        return doctorRepository.count();
    }

    public Page<Doctor> getAllDoctorsPages(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }

    public Page<Doctor> getAllDoctorsBySpecialtyIdPages(int id, Pageable pageable) {
        return doctorRepository.findAllBySpecialtyId(id, pageable);
    }

    public Page<Doctor> getAllDoctorsByDoctorNamePages(String name, Pageable pageable) {
        return doctorRepository.findAllByDoctorName(name, pageable);
    }

    public Page<Doctor> getAllDoctorsByDoctorNameAndSpecialtyIdPages(String name, int id, Pageable pageable) {
        return doctorRepository.findAllByDoctorNameAndSpecialtyId(name, id, pageable);
    }
}
