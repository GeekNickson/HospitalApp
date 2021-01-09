package com.hospital.app.repository;


import com.hospital.app.model.Doctor;
import com.hospital.app.model.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DoctorRepository extends PagingAndSortingRepository<Doctor, Integer> {
    List<Doctor> findBySpecialtyId(int id);

    Doctor findById(int id);

    List<Doctor> findByDoctorName(String doctorName);

    List<Doctor> findByDoctorNameAndSpecialtyId(String name, int id);

    Page<Doctor> findAllBySpecialtyId(int id, Pageable pageable);

    Page<Doctor> findAllByDoctorName(String name, Pageable pageable);

    Page<Doctor> findAllByDoctorNameAndSpecialtyId(String name, int id, Pageable pageable);
}
