package com.example.passengerservice.service.Impl;

import com.example.passengerservice.dto.AuthenticationResponse;
import com.example.passengerservice.dto.RideRequestDto;
import com.example.passengerservice.entity.RideRequest;
import com.example.passengerservice.repository.RideRequestRepo;
import com.example.passengerservice.service.JwtService;
import com.example.passengerservice.service.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestImpl implements RideRequestService {
    private final RideRequestRepo rideRequestRepo;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    @Override
    public RideRequestDto requestRide(RideRequestDto dto) {
        return modelMapper.map(rideRequestRepo.save(modelMapper.map(dto, RideRequest.class)),
                RideRequestDto.class);

    }

    @Override
    public RideRequestDto getSpecificRide(Integer passengerId, Integer rideId) {
        System.out.println(2);
        return modelMapper.map(rideRequestRepo.findByPassengerIdAndId(passengerId,rideId),
                RideRequestDto.class);
    }
}
