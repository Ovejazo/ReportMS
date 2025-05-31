package com.tutorial.reportservice.service;

//import edu.mtisw.payrollbackend.repositories.EmployeeRepository;
//import edu.mtisw.payrollbackend.repositories.ExtraHoursRepository;
import com.tutorial.reportservice.model.Booking;
import com.tutorial.reportservice.model.Client;
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

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<List<Booking>> getReportOfBookings() {
        ResponseEntity<List<Booking>> bookingsResponse = restTemplate.exchange(
                "http://bookingVoucherMS/api/v1/booking/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Booking>>() {}
        );
        List<Booking> bookings = bookingsResponse.getBody();

        return ResponseEntity.ok(bookings);
    }

    public ResponseEntity<List<Client>> getClientsForReports() {
        ResponseEntity<List<Client>> clientsResponse = restTemplate.exchange(
                "http://clientMS/api/v1/clients/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Client>>() {}
        );
        List<Client> clients = clientsResponse.getBody();

        return ResponseEntity.ok(clients);
    }
}
