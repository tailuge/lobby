package com.tailuge.lobby.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lobby {
    @Id
    @GeneratedValue
    private Long id;
    String name;
    @Getter
    @Setter(AccessLevel.NONE)
    @OneToMany
    final Set<Player> players = new HashSet<>();

}
