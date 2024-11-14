package com.learning.testing.students_courses.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExternalService {

    private final WebClient webClient;


    @Autowired
    public ExternalService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getDataFromExternalApi() {
        String url = "http://10.42.19.18:8080/api/jsonfile";

        // Make the request and retrieve the body as a Mono<String>
        Mono<String> response = webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);

        // Block and get the response synchronously (optional)
        return response.block();
    }

    // Method to delete all operators
    public Mono<String> deleteAllOperators() {
        return webClient
                .delete()
                .uri("/operators")  // Assuming the endpoint is `/operators`
                .retrieve()
                .bodyToMono(String.class) // Assuming response is of type String, can adjust as per response
                .onErrorResume(e -> Mono.just("Error deleting operators: " + e.getMessage()));
    }
}
