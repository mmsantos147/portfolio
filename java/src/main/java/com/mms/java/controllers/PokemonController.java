package com.mms.java.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mms.java.entity.Pokemon;
import com.mms.java.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    private ObjectMapper objectMapper;

    @Autowired
    public PokemonController(PokemonService pokemonService, ObjectMapper objectMapper) {
        this.pokemonService = pokemonService;
        this.objectMapper = objectMapper;
    }



    @GetMapping
    public List<Pokemon> getPokemon() {
        return pokemonService.getPokemon();
    }

    @GetMapping(path = "{pokemonName}")
    public Pokemon getPokemonByName(@PathVariable("pokemonName") String name) {
        return pokemonService.getPokemonByName(name);
    }

    @PostMapping
    public void registerNewPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.addNewPokemon(pokemon);
    }

    @DeleteMapping(path = "{pokemonName}")
    public void deletePokemon(@PathVariable("pokemonName") String name) {
        pokemonService.deletePokemon(name);
    }

/*    @PatchMapping("/pokemon/{pokemonName}")
      public Pokemon patchPokemon(@PathVariable("pokemonName") String name, @RequestBody Map<String, Object> patchPayload) {

      Pokemon tempPokemon = pokemonService.findByName(name);
      //excecao se nulo e se tiver id no request

      Pokemon patchedPokemon = apply(patchPayLoad, tempPokemon);
      pokemonService.save(patchedPokemon);
    }
     private Pokemon apply(Map<String,Object> patchPayload, Pokemon tempPokemon) {

      ObjectNode pokemonNode = objectMapper.convertValue(tempPokemon, ObjectNode.class);

      ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

      pokemonNode.setAll(patchNode);

      return objectMapper.convertValue(pokemonNode, Pokemon.class);

   }*/

}
