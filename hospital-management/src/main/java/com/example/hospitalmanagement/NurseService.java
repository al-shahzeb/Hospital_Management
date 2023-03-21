package com.example.hospitalmanagement;

import org.springframework.stereotype.Service;

@Service
public class NurseService {

    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse){
        String res = nurseRepository.addNurse(nurse);
        return res;
    }
}
