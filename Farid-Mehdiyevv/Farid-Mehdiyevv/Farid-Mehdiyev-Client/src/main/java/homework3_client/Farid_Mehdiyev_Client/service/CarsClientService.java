package homework3_client.Farid_Mehdiyev_Client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class CarsClientService {

    private final WebClient webClient;

    public CarsClientService(@Value("${first.app.base-url}") String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Mono<String> getCars() {
        return webClient.get()
                .uri("/cars")
                .retrieve()
                .bodyToMono(String.class);
    }
}
