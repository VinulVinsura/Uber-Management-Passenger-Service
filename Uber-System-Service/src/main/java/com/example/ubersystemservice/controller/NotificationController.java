package com.example.ubersystemservice.controller;

import com.example.ubersystemservice.dto.NotificationDto;
import com.example.ubersystemservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    //The notification is posted by the system
    @PostMapping("/post-notification")
    public ResponseEntity<NotificationDto> postNotification(@RequestBody NotificationDto dto){
        NotificationDto notificationDto = notificationService.postNotification(dto);
        return ResponseEntity.ok(notificationDto);
    }

    //Retrieve all notifications for the passenger.
    @GetMapping("/all-notifications")
    public ResponseEntity<List<NotificationDto>> getAllNotification(){
        List<NotificationDto> notificationDtoList = notificationService.getAllNotification();
        return ResponseEntity.ok(notificationDtoList);

    }



}
