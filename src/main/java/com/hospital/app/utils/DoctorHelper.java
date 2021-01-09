package com.hospital.app.utils;

public class DoctorHelper {
    private Integer id;
    private String name;
    private String category;
    private String specialty;
    private String schedule;

    public DoctorHelper(Integer id, String name, String category, String specialty, String schedule) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.specialty = specialty;
        this.schedule = schedule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
