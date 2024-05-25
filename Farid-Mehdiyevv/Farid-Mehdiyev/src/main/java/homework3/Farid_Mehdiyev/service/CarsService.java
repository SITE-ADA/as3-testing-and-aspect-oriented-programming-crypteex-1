package homework3.Farid_Mehdiyev.service;

import homework3.Farid_Mehdiyev.model.DTO.CarsDTO;
import homework3.Farid_Mehdiyev.model.entity.Cars;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CarsService {

    Cars save(Cars c);
    void deleteById(Long id);
    Optional<Cars> getById(Long id);
    Optional<Cars> update(Long id, Cars c);
    Optional<Cars> partialUpdate(Long id, Map<String, Object> c);
    List<CarsDTO> list();
}
