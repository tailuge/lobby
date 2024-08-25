package com.tailuge.lobby.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tailuge.lobby.model.Lobby;
import com.tailuge.lobby.repository.LobbyRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(LobbyRepository lobbyRepository) {
        return args -> {
            Lobby snookerLobby = Lobby.builder().name("snooker").build();
            lobbyRepository.save(snookerLobby);

            log.info("Initialized snooker lobby");
        };
    }
}
