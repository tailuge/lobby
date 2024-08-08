package com.tailuge.lobby;

import com.tailuge.lobby.model.Lobby;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.bind.annotation.*;

@Slf4j
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
@RestController
@RequestMapping("/lobbies")
public class LobbyController {

    @Autowired
    private LobbyRepository lobbyRepository;

    @PostMapping("/{lobbyId}/players/{playerId}")
    public Lobby addPlayer(@PathVariable Long lobbyId, @PathVariable Long playerId) {
        Lobby lobby = lobbyRepository.findById(lobbyId).orElseThrow(()->new ResourceNotFoundException("Lobby not found"));
        log.info("Adding player {} to lobby {}:{}", playerId, lobbyId, lobby.getName());
        return Lobby.builder().build();
    }
}
