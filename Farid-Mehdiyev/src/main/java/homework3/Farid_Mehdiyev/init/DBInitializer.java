package homework3.Farid_Mehdiyev.init;


import homework3.Farid_Mehdiyev.model.entity.Cars;
import homework3.Farid_Mehdiyev.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer {

    @Bean
    @Autowired
    public CommandLineRunner init(CarsRepository carsRepository) {

        return (args) -> {

          Cars c1 = carsRepository.save(new Cars("Mercedes Benz", "2014", "Non-amg"));
          Cars c2 = carsRepository.save(new Cars("BMW", "2012", "Non-M"));
          Cars c3 = carsRepository.save(new Cars("Toyota", "2021", "Dubai version"));
          Cars c4 = carsRepository.save(new Cars("Hyundai", "2011", "Tunning"));

    carsRepository.save(c1);
            carsRepository.save(c2);
            carsRepository.save(c3);
            carsRepository.save(c4);


        };

    }

}
