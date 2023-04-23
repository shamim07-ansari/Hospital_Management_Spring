package com.example.Hospital.Management;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    Map<Integer, Patient> map = new HashMap<>();

    @PostMapping("/addViaParameters")
    public String addPatient(@RequestParam("patientId")Integer patientId, @RequestParam("name") String name, @RequestParam("age")Integer age, @RequestParam("disease") String disease) {
        Patient patient = new Patient(patientId, name, age, disease);
        map.put(patientId, patient);
        return "Patient added successfully";
    }
    @PostMapping("/addViaRequestBody")
    public String addPatient(@RequestBody Patient patient) {
        int key = patient.getPatientId();
        map.put(key, patient);
        return "Patient added via request body";
    }
    @GetMapping("/getInfo")
    public Patient getPatient(@RequestParam("patientId") Integer patientId) {
        Patient patient = map.get(patientId);
        return patient;
    }
    @GetMapping("/getAll")
    public List<Patient> getAllPatient() {
        List<Patient> list = new ArrayList<>();
        for(Patient p : map.values()) {
            list.add(p);
        }
        return list;
    }
    @GetMapping("/getByName")
    public Patient getPatientByName(@RequestParam("name") String name) {
        for(Patient p : map.values()) {
            if(p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    @GetMapping("/getListGreaterThanAge")
    public List<Patient> getPatientListGreaterThanAge(int age) {
        List<Patient> list = new ArrayList<>();
        for(Patient p : map.values()) {
            if(p.getAge() > age) {
                list.add(p);
            }
        }
        return list;
    }
    @GetMapping("/getInfoViaPathVariable/{patientId}")
    public Patient getPatientInfo(@PathVariable("patientId") Integer patientId) {
        Patient patient = map.get(patientId);
        return patient;
    }
    @GetMapping("/getPatients/{age}/{disease}")
    public List<Patient> getPatients(@PathVariable("age")Integer age, @PathVariable("disease") String disease) {
        List<Patient> list = new ArrayList<>();
        for(Patient p : map.values()) {
            if(p.getAge() > age && disease.equals(p.getDisease())) {
                list.add(p);
            }
        }
        return list;
    }
    @PutMapping("/updateDetails")
    public String updatePatientDetails(@RequestBody Patient patient) {
        int key = patient.getPatientId();
        if(map.containsKey(key)) {
            map.put(key, patient);
            return "Patient details updated";
        }
        return "Patient is not exist";
    }
    @PutMapping("/updateDisease")
    public String updateDetails(@RequestParam("patientId") Integer patientId, @RequestParam("disease") String disease) {
        if(map.containsKey(patientId)) {
            Patient patient = map.get(patientId);
            patient.setDisease(disease);
            map.put(patientId, patient);
            return "Updated Successfully";
        }
        return "Patient is not exist";
    }
    @DeleteMapping("/delete")
    public String deletePatient(@RequestParam("patientId") int patientId) {
        map.remove(patientId);
        return "Patient deleted";
    }
}



