package com.example.passengerservice.repository;

import com.example.passengerservice.entity.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRequestRepo extends JpaRepository<RideRequest,Integer> {
}
