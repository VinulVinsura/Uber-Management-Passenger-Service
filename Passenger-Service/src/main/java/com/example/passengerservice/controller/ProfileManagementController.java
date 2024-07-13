package com.example.passengerservice.controller;

import com.example.passengerservice.dto.AuthenticationResponse;
import com.example.passengerservice.dto.LoginDto;
import com.example.passengerservice.dto.PassengerDto;
import com.example.passengerservice.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
