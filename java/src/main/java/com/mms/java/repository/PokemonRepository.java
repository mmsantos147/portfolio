package com.mms.java.repository;

import com.mms.java.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    @Query("select s from Pokemon s where s.name = ?1")
    Optional<Pokemon> findPokemonByName(String name);

    @Query("select s from Pokemon s where s.name LIKE %:name%")
    List<Pokemon> findPokemonsByName(@Param("name") String name);

}
