package work.model.mapper;

import org.apache.ibatis.annotations.*;
import work.model.dto.DoctorDto;

import java.util.List;

@Mapper
public interface DoctorMapper {
    @Insert("INSERT INTO doctor (name, specialty, phone) VALUES (#{name}, #{specialty}, #{phone})")
    int write(DoctorDto doctorDto);

    @Select("SELECT * FROM doctor")
    List<DoctorDto> list();

    @Select("SELECT * FROM doctor WHERE doctorid = #{doctorid}")
    DoctorDto view(int doctorid);

    @Update("UPDATE doctor SET name = #{name}, specialty = #{specialty}, phone = #{phone} WHERE doctorid = #{doctorid}")
    int update(DoctorDto doctorDto);

    @Delete("DELETE FROM doctor WHERE doctorid = #{doctorid}")
    int delete(int doctorid);
}
