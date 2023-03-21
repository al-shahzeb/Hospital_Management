package com.example.hospitalmanagement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {

    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse){
        String res = nurseRepository.addNurse(nurse);
        return res;
    }

    public List<Nurse> getNurseByQualification(String qualification){
        List<Nurse> nurseList= nurseRepository.getAllNurses();

        List<Nurse> resultantList = new ArrayList<>();

        for(Nurse nurse: nurseList){
            if(nurse.getQualification().equals(qualification))
                resultantList.add(nurse);
        }

        return resultantList;
    }
}
