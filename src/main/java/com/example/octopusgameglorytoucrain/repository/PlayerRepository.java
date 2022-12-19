package com.example.octopusgameglorytoucrain.repository;

import com.example.octopusgameglorytoucrain.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PlayerRepository extends CrudRepository<Player, UUID> {
    List<Player> findAll();
}
