package homework3.Farid_Mehdiyev;

import homework3.Farid_Mehdiyev.model.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Cars, Long> {
}
