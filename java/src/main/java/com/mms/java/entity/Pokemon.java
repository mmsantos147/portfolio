package com.mms.java.entity;
//#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String type1;
    private String type2;
    private Integer total;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer sp_atk;
    private Integer sp_def;
    private Integer speed;
    private Integer generation;
    private Boolean legendary;

    public Pokemon(String name, String type1, String type2, Integer total, Integer hp, Integer attack, Integer defense, Integer sp_atk, Integer sp_def, Integer speed, Integer generation, Boolean legendary) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.sp_atk = sp_atk;
        this.sp_def = sp_def;
        this.speed = speed;
        this.generation = generation;
        this.legendary = legendary;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", total=" + total +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", sp_atk=" + sp_atk +
                ", sp_def=" + sp_def +
                ", speed=" + speed +
                ", generation=" + generation +
                ", legendary=" + legendary +
                '}';
    }
}
