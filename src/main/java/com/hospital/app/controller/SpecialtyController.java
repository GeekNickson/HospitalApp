package com.hospital.app.controller;

import com.hospital.app.model.Doctor;
import com.hospital.app.model.Specialty;
import com.hospital.app.repository.DoctorRepository;
import com.hospital.app.repository.SpecialtyRepository;
import com.hospital.app.service.DoctorService;
import com.hospital.app.service.SpecialtyService;
import com.hospital.app.utils.DataTable;
import com.hospital.app.utils.DoctorHelper;
import com.hospital.app.utils.SpecialtyHelper;
import com.hospital.app.utils.StructurizedDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/specialty")
public class SpecialtyController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SpecialtyService specialtyService;

    private static int specialtyIdStored;

    @GetMapping("/specialties")
    public ModelAndView listSpecialties(ModelAndView model) throws IOException {
        model.setViewName("specialties");
        return model;
    }

    @GetMapping("/get_specialties")
    @ResponseBody
    public ResponseEntity listAllSpecialties(@RequestParam("draw") int draw,
                                             @RequestParam("order[0][dir]") String order,
                                             @RequestParam("start") int start,
                                             @RequestParam("length") int length) {
        int page = start / length;
        List<SpecialtyHelper> specialties = new ArrayList<>();

        Pageable pageable = PageRequest.of(
                page,
                length,
                Sort.by(Sort.Direction.fromString(order), "id")
        );

        Page<Specialty> responseData = specialtyService.getAllSpecialtiesPages(pageable);

        for (Specialty specialty : responseData.getContent()) {
            specialties.add(new SpecialtyHelper(specialty.getId(), specialty.getSpecialtyName()));
        }

        DataTable dataTable = new DataTable();

        dataTable.setData(specialties);
        dataTable.setRecordsTotal(responseData.getTotalElements());
        dataTable.setRecordsFiltered(responseData.getTotalElements());

        dataTable.setDraw(draw);
        dataTable.setStart(start);

        return ResponseEntity.ok(dataTable);
    }

    @GetMapping("/find_doctors")
    public ModelAndView listDoctors(ModelAndView model, @RequestParam("specialty") String specialtyId) {
        specialtyIdStored = Integer.parseInt(specialtyId);
        model.setViewName("doctors");
        return model;
    }

    @GetMapping("/get_doctors")
    @ResponseBody
    public ResponseEntity listDoctorsWorkingChosenSpecialty(@RequestParam("draw") int draw,
                                                            @RequestParam("order[0][dir]") String order,
                                                            @RequestParam("start") int start,
                                                            @RequestParam("length") int length) {
        int page = start / length;

        List<DoctorHelper> doctors = new ArrayList<>();

        Pageable pageable = PageRequest.of(
                page,
                length,
                Sort.by(Sort.Direction.fromString(order), "id")
        );

        Page<Doctor> responseData = doctorService.getAllDoctorsBySpecialtyIdPages(specialtyIdStored, pageable);

        for (Doctor doctor : responseData.getContent()) {
            doctors.add(new DoctorHelper(doctor.getId(), doctor.getDoctorName(), doctor.getCategory(), doctor.getSpecialty().getSpecialtyName(), doctor.getDoctorSchedule()));
        }

        DataTable dataTable = new DataTable();

        dataTable.setData(doctors);
        dataTable.setRecordsTotal(responseData.getTotalElements());
        dataTable.setRecordsFiltered(responseData.getTotalElements());

        dataTable.setDraw(draw);
        dataTable.setStart(start);

        return ResponseEntity.ok(dataTable);
    }

    @GetMapping("/doctor")
    public ModelAndView getDoctor(ModelAndView model, @RequestParam("doctor") String doctorId) {
        Doctor doctor = doctorService.getDoctorById(Integer.parseInt(doctorId));
        model.addObject("doctor", doctor);
        model.setViewName("doctor");
        return model;
    }
}
