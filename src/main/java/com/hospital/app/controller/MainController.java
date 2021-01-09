package com.hospital.app.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hospital.app.model.Doctor;
import com.hospital.app.model.Specialty;
import com.hospital.app.repository.DoctorRepository;
import com.hospital.app.repository.SpecialtyRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @GetMapping("/")
    public ModelAndView getStartPage(ModelAndView model) {
        model.setViewName("index");
        return model;
    }

}
