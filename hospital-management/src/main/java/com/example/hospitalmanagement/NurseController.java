package com.example.hospitalmanagement;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    NurseService nurseService = new NurseService();

    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse){
        String res = nurseService.addNurse(nurse);
        return res;
    }

    @GetMapping("/getByQualification")
    public List<Nurse> getNurseByQualification(String qualification){
        List<Nurse> nurseList = nurseService.getNurseByQualification(qualification);
        return nurseList;
    }
}
