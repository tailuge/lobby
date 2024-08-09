package com.tailuge.lobby;

import com.tailuge.lobby.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long>, CrudRepository<Player, Long> {

}

