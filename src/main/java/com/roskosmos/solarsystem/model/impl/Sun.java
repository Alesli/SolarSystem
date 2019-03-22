package com.roskosmos.solarsystem.model.impl;

import com.roskosmos.solarsystem.model.SpaceBody;
import com.roskosmos.solarsystem.model.impl.Planet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sun extends SpaceBody {

    private List<Planet> planets;

    public Sun(Long id, int orbit, String name) {
        super(id, orbit, name);
    }

    @Override
    public String toString() {

        StringBuilder planetsString = new StringBuilder("\tПланет нет\n");

        if (!planets.isEmpty()) {
            planetsString.setLength(0);
            planets.forEach(e -> planetsString.append("\t").append(e).append("\n"));
        }

        return super.toString() + "\n\n" + planetsString;
    }
}
