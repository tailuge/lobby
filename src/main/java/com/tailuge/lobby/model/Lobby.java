package com.tailuge.lobby.model;

import jakarta.persistence.*;
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
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    final Set<Player> players = new HashSet<>();

}
