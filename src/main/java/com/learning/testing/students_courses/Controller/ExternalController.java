package com.learning.testing.students_courses.Controller;

import com.learning.testing.students_courses.Service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/extenal")
public class ExternalController {

    private final ExternalService externalService;

    @Autowired
    public ExternalController(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/data")
    public String getExternalData() {
        return externalService.getDataFromExternalApi();
    }

    @DeleteMapping("/delete-operators")
    public Mono<ResponseEntity<String>> deleteAllOperators() {
        return externalService.deleteAllOperators()
                .map(response -> ResponseEntity.ok().body(response));
    }
}
