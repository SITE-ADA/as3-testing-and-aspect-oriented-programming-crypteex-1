package homework3.Farid_Mehdiyev.service.impl;

import lombok.NoArgsConstructor;
import homework3.Farid_Mehdiyev.model.DTO.CarsDTO;
import homework3.Farid_Mehdiyev.model.entity.Cars;
import homework3.Farid_Mehdiyev.model.mapper.CarsMapper;
import homework3.Farid_Mehdiyev.repository.CarsRepository;
import homework3.Farid_Mehdiyev.service.CarsService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


@Service
public class CarsServiceImpl implements CarsService {

    private CarsRepository carsRepository;

    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public Cars save(Cars c) {
        return carsRepository.save(c);
    }

    @Override
    public void deleteById(Long id) {
        carsRepository.deleteById(id);
    }

    @Override
    public Optional<Cars> getById(Long id) {
        return carsRepository.findById(id);
    }

    @Override
    public Optional<Cars> update(Long id, Cars c) {
        Optional<Cars> oldCar = carsRepository.findById(id);
        if (oldCar.isEmpty()) return oldCar;

        c.setId(id);

        return Optional.of(carsRepository.save(c));
    }

    @Override
    public List<CarsDTO> list() {
        var cars = carsRepository.findAll();

        return CarsMapper.INSTANCE.carsListToCarsDTOList(cars);
    }

    @Override
    @SneakyThrows
    public Optional<Cars> partialUpdate(Long id, Map<String, Object> map) {
        Optional<Cars> oldCar = carsRepository.findById(id);

        if (oldCar.isEmpty()) return oldCar;

        Cars car = oldCar.get();
        map.forEach((fieldName, value) -> {
            try {
                Field field = ReflectionUtils.findField(Cars.class, fieldName);
                assert field != null;
                field.setAccessible(true);
                field.set(car, value);
            } catch (Exception ignored) {
            }
        });

        return Optional.of(carsRepository.save(car));
    }
}
