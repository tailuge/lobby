package com.tailuge.lobby;

import com.tailuge.lobby.model.Lobby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface LobbyRepository extends PagingAndSortingRepository<Lobby, Long>, CrudRepository<Lobby, Long> {

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Lobby entity);
}

