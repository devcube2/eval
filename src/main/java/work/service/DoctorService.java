package work.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.dto.DoctorDto;
import work.model.mapper.DoctorMapper;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    public int write(DoctorDto doctorDto) {
        return doctorMapper.write(doctorDto);
    }

    public List<DoctorDto> list() {
        return doctorMapper.list();
    }

    public DoctorDto view(int doctorid) {
        return doctorMapper.view(doctorid);
    }

    public int update(DoctorDto doctorDto) {
        return doctorMapper.update(doctorDto);
    }

    public int delete(int doctorid) {
        return doctorMapper.delete(doctorid);
    }
}
