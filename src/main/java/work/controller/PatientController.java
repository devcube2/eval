package work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import work.model.dto.PatientDto;
import work.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/hospital-management/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("")
    public int write(@RequestBody PatientDto patientDto) {
        System.out.println("PatientController.write");
        System.out.println("patientDto = " + patientDto);
        return patientService.write(patientDto);
    }

    @GetMapping("")
    public List<PatientDto> list() {
        System.out.println("PatientController.list");
        return patientService.list();
    }

    @GetMapping("/view")
    public PatientDto view(int patientid) {
        System.out.println("PatientController.view");
        System.out.println("patientid = " + patientid);
        return patientService.view(patientid);
    }

    @PutMapping("")
    public int update(@RequestBody PatientDto patientDto) {
        System.out.println("PatientController.update");
        System.out.println("patientDto = " + patientDto);
        return patientService.update(patientDto);
    }

    @DeleteMapping("")
    public int delete(int patientid) {
        System.out.println("PatientController.delete");
        System.out.println("patientid = " + patientid);
        return patientService.delete(patientid);
    }
}
