package homework3_client.Farid_Mehdiyev_Client.Controller;


import homework3_client.Farid_Mehdiyev_Client.service.CarsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/cars")
public class CarsClientController {

    @Autowired
    private CarsClientService carsClientService;

    @GetMapping
    public ResponseEntity<String>
    getAllCars() {
        return ResponseEntity.ok(carsClientService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String>
    getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carsClientService.getCarById(id));
    }

    @PostMapping
    public ResponseEntity<String>
    createCar(@RequestBody Object car) {
        return ResponseEntity.ok(carsClientService.createCar(car));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void>
    updateCar(@PathVariable Long id, @RequestBody Object car) {
        carsClientService.updateCar(id, car);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carsClientService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
