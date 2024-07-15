package com.example.passengerservice.controller;

import com.example.passengerservice.dto.RideRequestDto;
import com.example.passengerservice.service.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class RideRequestController {

    private final RideRequestService rideRequestService;

    //Request a new ride. (POST API)
    @PostMapping("/rides")
    public ResponseEntity<RideRequestDto> postRequestRide(@RequestBody RideRequestDto dto){
        RideRequestDto rideRequestDto = rideRequestService.requestRide(dto);
        return ResponseEntity.ok(rideRequestDto);

    }

    // Get details of a specific ride.(GET API)
    @GetMapping("/ride/{passengerId}/{rideId}")
    public ResponseEntity<RideRequestDto> getSpecificRide(@PathVariable Integer passengerId,
                                                          @PathVariable Integer rideId){

        try {
            RideRequestDto specificRide = rideRequestService.getSpecificRide(passengerId, rideId);
            return ResponseEntity.ok(specificRide);
        }catch (RuntimeException ex){
            return ResponseEntity.notFound().build();
        }



    }
}
