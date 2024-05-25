package homework3_client.Farid_Mehdiyev_Client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarsClientService {

    @Value("${cars.api.url}")
    private String carsApiUrl;

    private final RestTemplate restTemplate;

    public CarsClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAllCars() {
        return restTemplate.getForObject(carsApiUrl + "/cars", String.class);
    }

    public String getCarById(Long id) {
        return restTemplate.getForObject(carsApiUrl + "/cars/" + id, String.class);
    }

    public String createCar(Object car) {
        return restTemplate.postForObject(carsApiUrl + "/cars", car, String.class);
    }

    public void updateCar(Long id, Object car) {
        restTemplate.put(carsApiUrl + "/cars/" + id, car);
    }

    public void deleteCar(Long id) {
        restTemplate.delete(carsApiUrl + "/cars/" + id);
    }
}
