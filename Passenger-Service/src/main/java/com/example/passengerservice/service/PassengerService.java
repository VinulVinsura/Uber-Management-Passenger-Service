package com.example.passengerservice.service;

import com.example.passengerservice.dto.AuthenticationResponse;
import com.example.passengerservice.dto.PassengerDto;

public interface PassengerService {

    AuthenticationResponse registerPassenger(PassengerDto passengerDto);
}
