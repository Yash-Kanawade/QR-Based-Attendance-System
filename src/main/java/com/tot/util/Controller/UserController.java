package com.tot.util.Controller;

import com.google.zxing.WriterException;
import com.tot.util.module.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tot.util.repository.UserRepository;
import com.tot.util.service.AttendanceService;
import com.tot.util.service.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userservice;

    @Autowired
    private AttendanceService attservice;

    @Autowired
    private UserRepository userrepo;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users users) throws IOException, WriterException {
        try {
            Users registereduser = userservice.registerUser(users);
            return ResponseEntity.ok(registereduser.getUser_id());
        } catch (WriterException | IOException e) {
            return ResponseEntity.internalServerError().body("ERROR");
        }
    }

    @GetMapping("/showqr/{id}")
    public ResponseEntity<?> showQr(@PathVariable Integer id) {
        Optional<Users> optionalUser = userrepo.findById(id);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/show/{id}/image")
    public ResponseEntity<byte[]> getQrImage(@PathVariable int id) {
        Optional<Users> optionalUser = userrepo.findById(id);

        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            String qrCodePath = user.getQRData();

            if (qrCodePath == null || qrCodePath.isEmpty()) {
                System.err.println("QR code path is missing for user ID: " + id);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }

            try {
                Path imagePath = Paths.get(qrCodePath);
                byte[] imageBytes = Files.readAllBytes(imagePath);

                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_PNG)
                        .body(imageBytes);

            } catch (IOException e) {
                System.err.println("Error reading QR code image: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
