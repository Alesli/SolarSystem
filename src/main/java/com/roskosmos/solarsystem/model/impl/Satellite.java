package com.roskosmos.solarsystem.model.impl;

import com.roskosmos.solarsystem.model.SpaceBody;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Satellite extends SpaceBody {

    private Long planetId;
}