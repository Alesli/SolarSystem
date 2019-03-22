package com.roskosmos.solarsystem.model.impl;

import com.roskosmos.solarsystem.model.SpaceBody;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Planet extends SpaceBody {

    private Long sunId;
    private String type;
    private boolean habitable;
    private Long population;
    private List<Satellite> satellites;

    public Planet(Long id, Long sinId, int orbit, String name, String type, boolean habitable, long population) {
        super(id, orbit, name);
        this.sunId = sinId;
        this.type = type;
        this.habitable = habitable;
        this.population = population;
    }

    @Override
    public String toString() {

        StringBuilder satellitesList = new StringBuilder("\t\tСпутников нет\n");

        if (!satellites.isEmpty()) {
            satellitesList.setLength(0);
            satellites.forEach(e -> satellitesList.append("\t\t").append(e).append("\n"));
        }

        return super.toString() + " " +
                type + " " +
                (habitable ? "обитаема " : "необитаема ") +
                (habitable ? population : "") +
                "\n" +
                satellitesList;
    }
}
