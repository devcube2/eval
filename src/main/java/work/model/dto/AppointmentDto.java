package work.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private int appointmentid;
    private int patientid;
    private int doctorid;
    private String appointmentdate;
    private String appointmenttime;
    private int status;
}
