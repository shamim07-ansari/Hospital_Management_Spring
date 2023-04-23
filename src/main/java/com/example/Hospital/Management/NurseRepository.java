package com.example.Hospital.Management;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NurseRepository {
    Map<Integer, Nurse> map = new HashMap<>();
    public String addNurse(Nurse nurse) {
        int key = nurse.getNurseId();
        map.put(key, nurse);
        return "Nurse added successfully";
    }
    public List<Nurse> getAllNurses() {
        return map.values().stream().toList();
    }
}
