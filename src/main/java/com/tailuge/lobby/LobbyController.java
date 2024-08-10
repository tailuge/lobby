package com.tailuge.lobby;

import com.tailuge.lobby.model.Lobby;
import com.tailuge.lobby.model.Player;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
@RestController
@RequestMapping("/lobbies")
public class LobbyController {

    private final LobbyRepository lobbyRepository;

    private final PlayerRepository playerRepository;

    public LobbyController(LobbyRepository lobbyRepository, PlayerRepository playerRepository) {
        this.lobbyRepository = lobbyRepository;
        this.playerRepository = playerRepository;
    }

    @Transactional
    @PostMapping("/{lobbyId}/players/{playerId}")
    public Lobby addPlayer(@PathVariable Long lobbyId, @PathVariable Long playerId) {
        Lobby lobby = lobbyRepository.findById(lobbyId).orElseThrow(() -> new ResourceNotFoundException("Lobby not found"));
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new ResourceNotFoundException("Player not found"));
        log.info("Adding player {}:{} to lobby {}:{}", playerId, player.getName(), lobbyId, lobby.getName());
        lobby.getPlayers().add(player);
        return lobby;
    }
}
