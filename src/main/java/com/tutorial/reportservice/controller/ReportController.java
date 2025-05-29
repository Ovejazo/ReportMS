package com.tutorial.reportservice.controller;

import com.tutorial.reportservice.model.Booking;
import com.tutorial.reportservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    private RestTemplate restTemplate;

    //Vamos a conseguir los booking y hacemos las cosas por frontend
    @GetMapping("/report1/")
    public ResponseEntity<List<Booking>> geReport() {
        return reportService.getReport();
    }



}
