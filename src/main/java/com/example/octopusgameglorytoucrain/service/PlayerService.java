package com.example.octopusgameglorytoucrain.service;

import com.example.octopusgameglorytoucrain.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PlayerService {
    List<Player> getAll();

    Player save(UUID uuid);

    Player delete(UUID id);

    Player getById(UUID player_id);
}
