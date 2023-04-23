package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    Map<Integer, Doctor> map = new HashMap<>();
    @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor) {
        int key = doctor.getDoctorId();
        map.put(key, doctor);
        return "Doctor added successfully";
    }
}
