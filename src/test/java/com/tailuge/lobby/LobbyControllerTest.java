package com.tailuge.lobby;

import com.tailuge.lobby.controller.LobbyController;
import com.tailuge.lobby.model.Lobby;
import com.tailuge.lobby.model.Player;
import com.tailuge.lobby.repository.LobbyRepository;
import com.tailuge.lobby.repository.PlayerRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class LobbyControllerTest {

    @Autowired
    LobbyController lobbyController;

    @Autowired
    PlayerRepository playerRepository;
    
    @Autowired
    private LobbyRepository lobbyRepository;

    @Test
    void addPlayerThrowsWhenNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> lobbyController.addPlayer(1L, 2L));
    }

    @Test
    void addPlayerUpdatesCollection() {
        playerRepository.save(new Player(1L, "player1"));
        lobbyRepository.save(new Lobby(1L, "lobby1"));
        lobbyController.addPlayer(1L, 1L);
        Optional<Lobby> a = lobbyRepository.findById(1L);
        assertThat(a).isPresent()
                     .hasValueSatisfying(s ->
                             assertThat(s.getPlayers()).hasSize(1));
    }

}