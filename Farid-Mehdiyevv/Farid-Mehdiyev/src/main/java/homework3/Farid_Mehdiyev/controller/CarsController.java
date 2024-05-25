package homework3.Farid_Mehdiyev.controller;


import homework3.Farid_Mehdiyev.model.DTO.CarsDTO;
import homework3.Farid_Mehdiyev.model.entity.Cars;
import homework3.Farid_Mehdiyev.service.CarsService;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/cars")
public class CarsController {

    private CarsService carsService;

    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CarsDTO>
    listCars(){
        return carsService.list();
    }

    @GetMapping("/{carsId}")
    public ResponseEntity<Cars>
    getCarsById(@PathVariable("carsId") Long id) {
        Optional<Cars> result = carsService.getById(id);

        return result.isEmpty()
                ? new ResponseEntity<>(null, HttpStatus.NO_CONTENT)
                : ResponseEntity.ok(result.get());
    }

    @DeleteMapping("/{carsId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeById(@PathVariable("carsId") Long id) {
        carsService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public Cars saveCar(@RequestBody Cars car) {
        Cars newCar = carsService.save(car);
        return newCar;
    }

    @PutMapping("/{carsId}")
    public ResponseEntity<Cars> updateCars(@PathVariable("carsId") Long id, @RequestBody Cars newCar) {
        Optional<Cars> result = carsService.update(id, newCar);

        return result.isEmpty()
                ? new ResponseEntity<>(null, HttpStatus.NO_CONTENT)
                : ResponseEntity.ok(result.get());
    }

    @PatchMapping("/{carsId}")
    public ResponseEntity<Cars> updatePartiallyCars(@PathVariable("carsId") Long id,
                                                    @RequestBody Map<String, Object> params) {
        Optional<Cars> result = carsService.partialUpdate(id, params);

        return result.isEmpty()
                ? new ResponseEntity<>(null, HttpStatus.NO_CONTENT)
                : ResponseEntity.ok(result.get());
    }


}
