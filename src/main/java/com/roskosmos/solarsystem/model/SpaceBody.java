package com.roskosmos.solarsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class SpaceBody {

    private Long id;
    private int orbit;
    private String name;

    @Override
    public String toString() {
        return orbit + " " + name;
    }
}
