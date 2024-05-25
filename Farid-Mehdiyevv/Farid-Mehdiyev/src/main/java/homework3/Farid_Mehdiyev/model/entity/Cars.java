package homework3.Farid_Mehdiyev.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Car Type is mandatory") // validation
    private String carType;

    @NotBlank(message = "Car year is mandatory") // validation
    private String carYear;

    @NotBlank(message = "Car description is mandatory") // validation
    private String carDescription;


    public Cars(String carType, String carYear, String carDescription) {

        this.carType = carType;
        this.carYear = carYear;
        this.carDescription = carDescription;

    }


}
