package com.example.passengerservice.controller;

import com.example.passengerservice.dto.RideRequestDto;
import com.example.passengerservice.service.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class RideRequestController {

    private final RideRequestService rideRequestService;

    //Request a new ride.
    @PostMapping("/rides")
    public ResponseEntity<RideRequestDto> postRequestRide(@RequestBody RideRequestDto dto){
        RideRequestDto rideRequestDto = rideRequestService.requestRide(dto);
        return ResponseEntity.ok(rideRequestDto);

    }
}
