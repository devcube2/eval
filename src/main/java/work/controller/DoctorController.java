package work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.model.dto.DoctorDto;
import work.service.DoctorService;

import java.util.List;


@RestController
@RequestMapping("/hospital-management/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("")
    int write(@RequestBody DoctorDto doctorDto) {
        return doctorService.write(doctorDto);
    }

    @GetMapping("")
    List<DoctorDto> list() {
        return doctorService.list();
    }

    @GetMapping("/view")
    DoctorDto view(int doctorid) {
        return doctorService.view(doctorid);
    }

    @PutMapping("")
    int update(@RequestBody DoctorDto doctorDto) {
        return doctorService.update(doctorDto);
    }

    @DeleteMapping("")
    int delete(int doctorid) {
        return doctorService.delete(doctorid);
    }
}
