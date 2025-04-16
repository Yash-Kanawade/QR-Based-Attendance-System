package com.tot.util.service;

import com.tot.util.module.Attendance;
import com.tot.util.module.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tot.util.repository.AttendanceRepository;
import com.tot.util.repository.UserRepository;

import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attrepo;

    @Autowired
    private UserRepository userrepo;

    public String markedAttendance(Integer id)
    {
        Optional<Users> optionaluser = userrepo.findById(id);
        if(optionaluser.isPresent()){
            Attendance attendance = new Attendance();
            attendance.setUser(optionaluser.get());
            attrepo.save(attendance);
            return "Attendance marked";
        }
        return "User not found";
    }

}
