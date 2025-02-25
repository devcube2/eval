package work.model.mapper;

import org.apache.ibatis.annotations.*;
import work.model.dto.PatientDto;

import java.util.List;

@Mapper
public interface PatientMapper {
    @Insert("INSERT INTO patient (name, birthdate, phone, address) VALUES (#{name}, #{birthdate}, #{phone}, #{address})")
    int write(PatientDto patientDto);

    @Select("SELECT * FROM patient")
    List<PatientDto> list();

    @Select("SELECT * FROM patient WHERE patientid = #{patientid}")
    PatientDto view(int patientid);

    @Update("UPDATE patient SET name = #{name}, birthdate = #{birthdate}, phone = #{phone}, address = #{address} WHERE patientid = #{patientid}")
    int update(PatientDto patientDto);

    @Delete("DELETE FROM patient WHERE patientid = #{patientid}")
    int delete(int patientid);
}
