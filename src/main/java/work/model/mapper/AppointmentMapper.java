package work.model.mapper;

import org.apache.ibatis.annotations.*;
import work.model.dto.AppointmentDto;

import java.util.List;

@Mapper
public interface AppointmentMapper {
    @Insert("INSERT INTO appointment (patientid, doctorid, appointmentdate, appointmenttime, status) VALUES (#{patientid}, #{doctorid}, #{appointmentdate}, #{appointmenttime}, #{status})")
    int write(AppointmentDto appointmentDto);

    @Select("SELECT * FROM appointment")
    List<AppointmentDto> list();

    @Update("UPDATE appointment SET patientid = #{patientid}, doctorid = #{doctorid}, appointmentdate = #{appointmentdate}, appointmenttime = #{appointmenttime}, status = #{status} WHERE appointmentid = #{appointmentid}")
    int update(AppointmentDto appointmentDto);

    @Delete("DELETE FROM appointment WHERE appointmentid = #{appointmentid}")
    int delete(int appointmentid);
}
