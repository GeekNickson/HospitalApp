package com.hospital.app.service;


import com.hospital.app.model.Specialty;
import com.hospital.app.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyService {
    @Autowired
    SpecialtyRepository specialtyRepository;

    public List<Specialty> getAllSpecialties() {
        return (List<Specialty>) specialtyRepository.findAll();
    }

    public List<Specialty> saveAllSpecialties(List<Specialty> specialties) {
        return (List<Specialty>) specialtyRepository.saveAll(specialties);
    }

    public long countRows() {
        return specialtyRepository.count();
    }

    public Page<Specialty> getAllSpecialtiesPages(Pageable pageable) {
        return specialtyRepository.findAll(pageable);
    }
}
