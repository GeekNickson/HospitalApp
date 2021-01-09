package com.hospital.app.controller;

import com.hospital.app.model.Doctor;
import com.hospital.app.model.Specialty;
import com.hospital.app.repository.DoctorRepository;
import com.hospital.app.repository.SpecialtyRepository;
import com.hospital.app.service.DoctorService;
import com.hospital.app.service.SpecialtyService;
import com.hospital.app.utils.DataTable;
import com.hospital.app.utils.StructurizedDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(path = "/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/all_doctors")
    public ModelAndView allDoctors(ModelAndView model) throws IOException {
        List<Specialty> specialties = (List<Specialty>) specialtyService.getAllSpecialties();
        model.addObject("specialties", specialties);
        model.setViewName("filter");
        return model;
    }

    @GetMapping("/filter")
    @ResponseBody
    public ResponseEntity listAllDoctors(@RequestParam("draw") int draw,
                                         @RequestParam("order[0][dir]") String order,
                                         @RequestParam("start") int start,
                                         @RequestParam("length") int length,
                                         @RequestParam("specialty") String specialtyId,
                                         @RequestParam("name") String doctorName) {
        int page = start / length;
        List<StructurizedDoctor> doctors = new ArrayList<>();
        Pageable pageable = PageRequest.of(
                page,
                length,
                Sort.by(Sort.Direction.fromString(order), "id")
        );

        Page<Doctor> responseData;
        if (!specialtyId.equals("0") && !doctorName.equals("")) {
            responseData = doctorService.getAllDoctorsByDoctorNameAndSpecialtyIdPages(doctorName, Integer.parseInt(specialtyId), pageable);
        } else if (doctorName.equals("") && !specialtyId.equals("0")) {
            responseData = doctorService.getAllDoctorsBySpecialtyIdPages(Integer.parseInt(specialtyId), pageable);
        } else if (specialtyId.equals("0") && !doctorName.equals("")) {
            responseData = doctorService.getAllDoctorsByDoctorNamePages(doctorName, pageable);
        } else {
            responseData = doctorService.getAllDoctorsPages(pageable);
        }

        for (Doctor doctor : responseData.getContent()) {

            doctors.add(new StructurizedDoctor(doctor.getId(), doctor.getDoctorName(), doctor.getSpecialty().getSpecialtyName(), doctor.getCategory()));
        }

        DataTable dataTable = new DataTable();

        dataTable.setData(doctors);
        dataTable.setRecordsTotal(responseData.getTotalElements());
        dataTable.setRecordsFiltered(responseData.getTotalElements());

        dataTable.setDraw(draw);
        dataTable.setStart(start);

        return ResponseEntity.ok(dataTable);
    }
}
