package com.mms.java.service;

import com.mms.java.entity.Pokemon;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class PokemonService {
    public List<Pokemon> getPokemon() {
        return List.of(new Pokemon(
                "Charizard",
                "Fire",
                "Fly",
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                1,
                Boolean.FALSE
        ));
    }
}
