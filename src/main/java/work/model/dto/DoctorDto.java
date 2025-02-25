package work.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private int doctorid;
    private String name;
    private String specialty;
    private String phone;
    private String createdat;
}
