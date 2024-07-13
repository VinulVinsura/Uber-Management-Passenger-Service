package com.example.passengerservice.service.Impl;

import com.example.passengerservice.dto.AuthenticationResponse;
import com.example.passengerservice.dto.PassengerDto;
import com.example.passengerservice.entity.Passenger;
import com.example.passengerservice.repository.PassengerRepo;
import com.example.passengerservice.service.JwtService;
import com.example.passengerservice.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerImpl implements PassengerService {
    private final PassengerRepo passengerRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Override
    public AuthenticationResponse registerPassenger(PassengerDto passengerDto) {
        Passenger passenger=new Passenger();
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setAddress(passengerDto.getAddress());
        passenger.setContactNum(passengerDto.getContactNum());
        passenger.setPassword(passwordEncoder.encode(passengerDto.getPassword()));
        Passenger savedPassenger = passengerRepo.save(passenger);
        String toke = jwtService.generateToke(savedPassenger);
        return new AuthenticationResponse(toke);

    }
}
