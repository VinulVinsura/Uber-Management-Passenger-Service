package com.example.passengerservice.controller;

import com.example.passengerservice.dto.AuthenticationResponse;
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

    @PostMapping("/register") //password="123"
    public ResponseEntity<AuthenticationResponse> registerPassenger(@RequestBody PassengerDto passengerDto){
        AuthenticationResponse authenticationResponse = passengerService.registerPassenger(passengerDto);
        return ResponseEntity.ok(authenticationResponse);
    }
}
