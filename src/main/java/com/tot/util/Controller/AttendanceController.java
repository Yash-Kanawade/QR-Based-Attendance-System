package com.tot.util.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tot.util.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "http://localhost:3000")
public class AttendanceController {
    @Autowired
    private AttendanceService service;
    @PostMapping("/mark/{id}")
    public ResponseEntity<?> attendaceScan(@PathVariable Integer id){
        String str = service.markedAttendance(id);
        if(str.equals("Attendance marked"))
            return ResponseEntity.ok("Marked!!");
        else
            return ResponseEntity.internalServerError().build();
    }
}
