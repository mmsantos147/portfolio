package com.mms.java.service;

import com.mms.java.entity.Pokemon;
import com.mms.java.entity.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiService {
    private final RestTemplate restTemplate;

    public ApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<User> getUsers() {
        String url = "http://localhost:8080/api/users";
        ResponseEntity<List<User>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {}
        );
        return response.getBody();
    }

    public List<Pokemon> getPokemon() {
        String url = "http://localhost:8080/api/pokemon";
        ResponseEntity<List<Pokemon>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Pokemon>>() {}
        );
        return response.getBody();
    }

    public List<Pokemon> getPokemonByName(String name) {
        String url = "http://localhost:8080/api/pokemon/search/"  + name;
        ResponseEntity<List<Pokemon>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Pokemon>>() {}
        );
        return response.getBody();
    }
}
