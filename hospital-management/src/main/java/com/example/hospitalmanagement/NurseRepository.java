package com.example.hospitalmanagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class NurseRepository {

    HashMap<Integer,Nurse> nurseHashMap = new HashMap<>();

    public String addNurse(Nurse nurse){
        nurseHashMap.put(nurse.getNurseId(),nurse);
        return "Nurse Added";
    }
}
