package homework3.Farid_Mehdiyev.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsDTO {
    private Long id;

    private String carsType;

    private String carsYear;

    private String carsDescription;


}
