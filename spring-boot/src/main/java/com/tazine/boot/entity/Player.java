package com.tazine.boot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Player
 *
 * @author frank
 * @since 1.0.0
 */
@Entity
public class Player {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String team;

    @Min(value = 0, message = "球衣号码应在0-99之间")
    @Max(value = 99, message = "球衣号码应在0-99之间")
    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", number=" + number +
                '}';
    }
}
