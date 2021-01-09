package com.hospital.app.model;

import javax.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String doctorName;

    private String category;

    private String doctorSchedule;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    public Doctor() {

    }

    public Doctor(String doctorName, String category, String doctorSchedule, Specialty specialty) {
        this.doctorName = doctorName;
        this.category = category;
        this.doctorSchedule = doctorSchedule;
        this.specialty = specialty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDoctorSchedule() {
        return doctorSchedule;
    }

    public void setDoctorSchedule(String doctorSchedule) {
        this.doctorSchedule = doctorSchedule;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", category='" + category + '\'' +
                ", doctorSchedule='" + doctorSchedule + '\'' +
                '}';
    }
}
