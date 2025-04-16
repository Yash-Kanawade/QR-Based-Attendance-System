package com.tot.util.service;

import com.tot.util.*;

import com.google.zxing.WriterException;
import com.tot.util.module.Users;
import com.tot.util.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users registerUser(Users user) throws WriterException, IOException {
        Users savedUser = userRepository.save(user);
        String qrText = "http://localhost:3000/scan/" + savedUser.getUser_id();
        String qrFilePath = "src/main/resources/static/qrCodes/user_" + savedUser.getUser_id() + ".png";
        QRGenerator.generateQRCode(qrText, 200, 200, qrFilePath);
        savedUser.setQRData(qrFilePath);
        return userRepository.save(savedUser);
    }
}
