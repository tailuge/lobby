package com.tailuge.lobby;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class LobbyControllerTest {

    @Autowired
    LobbyController lobbyController;

    @Test
    void addPlayerThrows() {
        assertThrows(ResourceNotFoundException.class, () -> lobbyController.addPlayer(1L, 2L));
    }
}