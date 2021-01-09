package com.hospital.app.repository;


import com.hospital.app.model.Specialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpecialtyRepository extends PagingAndSortingRepository<Specialty, Integer> {
    Specialty findBySpecialtyName(String specialtyName);

}
