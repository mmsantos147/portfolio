package com.mms.java.service;

import com.mms.java.entity.Pokemon;
import com.mms.java.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class PokemonService {

    private final PokemonRepository  pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getPokemon() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonByName(String name) {
        Optional<Pokemon> pokemonByName = pokemonRepository.findPokemonByName(name);
        if(pokemonByName.isEmpty()) {
            throw new IllegalStateException("pokemon with name" + name + "does not exists");
        }

        return pokemonByName;
    }

    public void addNewPokemon(Pokemon pokemon){
        Optional<Pokemon> pokemonByName = pokemonRepository.findPokemonByName(pokemon.getName());
        if (pokemonByName.isPresent()) {
            throw new IllegalStateException("pokemon already exists");
        }
        pokemonRepository.save(pokemon);
        System.out.println(pokemon);
    }

    public void deletePokemon(String name) {
        Optional<Pokemon> pokemonByName = pokemonRepository.findPokemonByName(name);
        if(pokemonByName.isEmpty()) {
            throw new IllegalStateException("pokemon with name" + name + "does not exists");
        }

        pokemonRepository.deleteById(pokemonByName.get().getId());
    }
}
