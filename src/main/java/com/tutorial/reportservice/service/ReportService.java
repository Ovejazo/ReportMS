package com.tutorial.reportservice.service;

//import edu.mtisw.payrollbackend.repositories.EmployeeRepository;
//import edu.mtisw.payrollbackend.repositories.ExtraHoursRepository;
import com.tutorial.reportservice.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    private RestTemplate restTemplate;
    public ResponseEntity<List<Booking>> getReport() {
        ResponseEntity<List<Booking>> bookingsResponse = restTemplate.exchange(
                "http://bookingVoucherMS/api/v1/booking/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Booking>>() {}
        );
        List<Booking> bookings = bookingsResponse.getBody();

        return ResponseEntity.ok(bookings);
    }
}
