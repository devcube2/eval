package work.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import work.model.dto.AppointmentDto;
import work.model.mapper.AppointmentMapper;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;

    public int write(AppointmentDto appointmentDto) {
        return appointmentMapper.write(appointmentDto);
    }

    public List<AppointmentDto> list() {
        return appointmentMapper.list();
    }

    public int update(AppointmentDto appointmentDto) {
        return appointmentMapper.update(appointmentDto);
    }

    public int delete(int appointmentid) {
        return appointmentMapper.delete(appointmentid);
    }
}
