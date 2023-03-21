package com.example.hospitalmanagement;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PatientController {

    Map<Integer,Patient> patientMap = new HashMap<>();

    //posting using requestparams
    @PostMapping("/addPatients")
    public String addPatient(@RequestParam("patientId")Integer patientId,
                             @RequestParam("name")String name,
                             @RequestParam("age")Integer age,
                             @RequestParam("disease")String disease){

        Patient patient = new Patient(patientId,name,age,disease);
        patientMap.put(patientId,patient);
        return "Patient added";
    }


    @GetMapping("/getPatInfo/{age}/{disease}")
    public List<Patient> giveInfo(@PathVariable("age")Integer age,
                                  @PathVariable("disease")String disease){

        List<Patient> list = new ArrayList<>();
        for(Patient p: patientMap.values()){
            if(p.getDisease().equals(disease) && p.getAge()>age)
                list.add(p);
        }

        return list;
    }

    @GetMapping("/allPatients")
    public List<Patient> getAllPatients(){
        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientMap.values())
            patients.add(p);

        return patients;
    }

    @GetMapping("/patientInfo")
    public Patient getPatient(@RequestParam("patientId")Integer patientId){
        return patientMap.get(patientId);
    }

    @GetMapping("/patientbyName")
    public Patient patientByName(@RequestParam("name")String name){
        for(Patient p: patientMap.values()){
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }

    @GetMapping("/patientWithMoreAge")
    public List<Patient> patientWithMoreAge(@RequestParam("age")Integer age){
        List<Patient> patients = new ArrayList<>();

        for(Patient p : patientMap.values()){
            if(p.getAge()>=age)
                patients.add(p);
        }

        return patients;
    }

    @PutMapping("/updateInfo")
    public String updatePatientInfo(@RequestBody Patient patient){

        int key = patient.getPatientId();

        patientMap.put(key,patient);

        return "Updated successfully";
    }
}
