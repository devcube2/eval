package work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.model.dto.AppointmentDto;
import work.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/hospital-management/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("")
    int write(@RequestBody AppointmentDto appointmentDto) {
        System.out.println("AppointmentController.write");
        System.out.println("appointmentDto = " + appointmentDto);
        return appointmentService.write(appointmentDto);
    }

    @GetMapping("")
    List<AppointmentDto> list() {
        System.out.println("AppointmentController.list");
        return appointmentService.list();
    }

    @PutMapping("")
    int update(@RequestBody AppointmentDto appointmentDto) {
        System.out.println("AppointmentController.update");
        System.out.println("appointmentDto = " + appointmentDto);
        return appointmentService.update(appointmentDto);
    }

    @DeleteMapping("")
    int delete(int appointmentid) {
        System.out.println("AppointmentController.delete");
        System.out.println("appointmentid = " + appointmentid);
        return appointmentService.delete(appointmentid);
    }
}
