package com.example.Hospital.Management;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PatientController {
    Map<Integer, Patient> map = new HashMap<>();

    @PostMapping("/addPatientViaParameters")
    public String addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("name") String name, @RequestParam("age")Integer age, @RequestParam("disease") String disease) {
        Patient patient = new Patient(patientId, name, age, disease);
        map.put(patientId, patient);
        return "Patient added successfully";
    }
    @PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient) {
        int key = patient.getPatientId();
        map.put(key, patient);
        return "Patient added via request body";
    }
    @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientId") Integer patientId) {
        Patient patient = map.get(patientId);
        return patient;
    }
    @GetMapping("/getAllPatient")
    public List<Patient> getAllPatient() {
        List<Patient> list = new ArrayList<>();
        for(Patient p : map.values()) {
            list.add(p);
        }
        return list;
    }
    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name") String name) {
        for(Patient p : map.values()) {
            if(p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    @GetMapping("/getPatientListGreaterThanAge")
    public List<Patient> getPatientListGreaterThanAge(int age) {
        List<Patient> list = new ArrayList<>();
        for(Patient p : map.values()) {
            if(p.getAge() > age) {
                list.add(p);
            }
        }
        return list;
    }
}
