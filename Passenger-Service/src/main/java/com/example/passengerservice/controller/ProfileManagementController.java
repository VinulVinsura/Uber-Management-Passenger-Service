package com.example.passengerservice.controller;

import com.example.passengerservice.dto.AuthenticationResponse;
import com.example.passengerservice.dto.LoginDto;
import com.example.passengerservice.dto.PassengerDto;
import com.example.passengerservice.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ProfileManagementController {

    private final PassengerService passengerService;

    // Register a new passenger
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerPassenger(@RequestBody PassengerDto passengerDto){
        AuthenticationResponse autheResponse = passengerService.registerPassenger(passengerDto);
        return ResponseEntity.ok(autheResponse);
    }

    // Authenticate and login a passenger.
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginPassenger(@RequestBody LoginDto loginDto){
        AuthenticationResponse response = passengerService.loginPassenger(loginDto);
        return ResponseEntity.ok(response);
    }

    // Retrieve passenger profile details
    @GetMapping("/getPassengerById/{id}")
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable Integer id){
        PassengerDto passengerDto = passengerService.getPassenger(id);
        return ResponseEntity.ok(passengerDto);
    }

    @GetMapping("/notification")
    public ResponseEntity<List> getNotification(){
        ResponseEntity<List> notification = passengerService.getNotification();
        return ResponseEntity.ok(notification.getBody());

    }

}
