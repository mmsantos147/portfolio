package com.mms.java.controllers;

import com.mms.java.entity.Pokemon;
import com.mms.java.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FrontController {
    private final ApiService apiService;

    @Autowired
    public FrontController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/pokemon/list")
    public String getPokemon(Model model){

        Pokemon pokemon = new Pokemon();
        List<Pokemon> pokemons = apiService.getPokemon();

        model.addAttribute("pokemon", pokemon);
        model.addAttribute("pokemons", pokemons);
        return "pokemons";
    }

    @RequestMapping("/pokemon/search")
    public String processPokeSearch(@ModelAttribute("pokemon") Pokemon pokemon, Model model) {
        System.out.println(pokemon.getName());
        List<Pokemon> pokemonName = apiService.getPokemonByName(pokemon.getName());
        if (pokemonName == null) {
            return "pokemons";
        }
        model.addAttribute("pokemon", pokemon);
        model.addAttribute("pokemons", pokemonName);
        return "processPokemonSearch";
    }

}
