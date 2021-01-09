package com.hospital.app.model;

import com.hospital.app.model.Doctor;

import javax.persistence.*;
import java.util.List;

@Entity
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String specialtyName;

    @OneToMany(mappedBy = "specialty")
    private List<Doctor> doctors;

    public Specialty() {

    }

    public Specialty(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", specialtyName='" + specialtyName + '\'' +
                '}';
    }
}
