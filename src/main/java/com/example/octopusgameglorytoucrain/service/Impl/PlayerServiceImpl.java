package com.example.octopusgameglorytoucrain.service.Impl;

import com.example.octopusgameglorytoucrain.api.exceptionHandler.exceptions.PlayerNotFoundException;
import com.example.octopusgameglorytoucrain.entity.Player;
import com.example.octopusgameglorytoucrain.repository.PlayerRepository;
import com.example.octopusgameglorytoucrain.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player save(final UUID uuid) {
        return playerRepository.save(new Player(uuid));
    }


    @Override
    public Player delete(final UUID id) {
        playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player with id " + id + " not found"));

        playerRepository.deleteById(id);

        return new Player(id);
    }

    @Override
    public Player getById(final UUID player_id) {
        return playerRepository.findById(player_id)
                .orElseThrow(() -> new PlayerNotFoundException("Player with id " + player_id + " not found"));
    }

}
