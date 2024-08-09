package com.tailuge.lobby.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    @Id
    @GeneratedValue
    private Long id;
    String name;

    @OneToMany
    final Set<Player> players = new HashSet<>();

    @OneToOne
    private Lobby lobby;
}
