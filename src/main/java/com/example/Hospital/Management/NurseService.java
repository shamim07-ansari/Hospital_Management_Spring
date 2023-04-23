package com.example.Hospital.Management;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {
    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse) {
        if(nurse.getNurseId() < 0) {
            return "Enter valid id";
        }
        if(nurse.getName().equals(null)) {
            return "Name is null";
        }
        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }

    public List<Nurse> getList(int age) {
        List<Nurse> list = new ArrayList<>();
        List<Nurse> nurses = nurseRepository.getAllNurses();
        for(Nurse nurse : nurses) {
            if(nurse.getAge() > age) {
                list.add(nurse);
            }
        }
        return list;
    }
    public List<Nurse> getNurseWithQualification(String qualification) {
        List<Nurse> list = new ArrayList<>();
        List<Nurse> nurseList = nurseRepository.getAllNurses();
        for(Nurse nurse : nurseList) {
            if(nurse.getQualification().equals(qualification)) {
                list.add(nurse);
            }
        }
        return list;
    }
}
