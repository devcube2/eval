package work.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private int patientid;
    private String name;
    private String birthdate;
    private String phone;
    private String address;
    private String createdat;
}
