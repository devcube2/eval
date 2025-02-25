package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.dto.PatientDto;
import work.model.mapper.PatientMapper;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientMapper patientMapper;

    public int write(PatientDto patientDto) {
        System.out.println("PatientService.write");
        System.out.println("patientDto = " + patientDto);
        return patientMapper.write(patientDto);
    }

    public List<PatientDto> list() {
        System.out.println("PatientService.list");
        return patientMapper.list();
    }

    public PatientDto view(int patientid) {
        System.out.println("PatientService.view");
        System.out.println("patientid = " + patientid);
        return patientMapper.view(patientid);
    }

    public int update(PatientDto patientDto) {
        System.out.println("PatientService.update");
        System.out.println("patientDto = " + patientDto);
        return patientMapper.update(patientDto);
    }

    public int delete(int patientid) {
        System.out.println("PatientService.delete");
        System.out.println("patientid = " + patientid);
        return patientMapper.delete(patientid);
    }
}
