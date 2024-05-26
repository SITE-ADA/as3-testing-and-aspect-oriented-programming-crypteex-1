package homework3_client.Farid_Mehdiyev_Client.Controller;


import homework3_client.Farid_Mehdiyev_Client.service.CarsClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CarsClientController {

    private final CarsClientService carsClientService;

    public CarsClientController(CarsClientService carsClientService) {
        this.carsClientService = carsClientService;
    }

    @GetMapping("/cars")
    public Mono<String> getCars() {
        return carsClientService.getCars();
    }
}
