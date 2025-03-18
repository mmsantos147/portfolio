package com.mms.java.controllers;

import com.mms.java.entity.Pokemon;
import com.mms.java.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getPokemon() {
        return pokemonService.getPokemon();
    }

    @PostMapping
    public void registerNewPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.addNewPokemon(pokemon);
    }

    @DeleteMapping(path = "{pokemonName}")
    public void deletePokemon(@PathVariable("pokemonName") String name) {
        pokemonService.deletePokemon(name);
    }
}
