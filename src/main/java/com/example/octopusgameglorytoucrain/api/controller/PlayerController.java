package com.example.octopusgameglorytoucrain.api.controller;

import com.example.octopusgameglorytoucrain.entity.Player;
import com.example.octopusgameglorytoucrain.entity.dto.PlayerDto;
import com.example.octopusgameglorytoucrain.mapper.Mapper;
import com.example.octopusgameglorytoucrain.mapper.PlayerMapper;
import com.example.octopusgameglorytoucrain.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
@CrossOrigin
public class PlayerController {
    private final PlayerService playerService;
    private final Mapper<Player, PlayerDto> playerMapper = Mappers.getMapper(PlayerMapper.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PlayerDto> getPlayers() {
        return playerService.getAll().stream().map(playerMapper::mapTo).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PlayerDto createPlayer() {
        return playerMapper.mapTo(playerService.save(UUID.randomUUID()));
    }

    @DeleteMapping("/{player_id}")
    @ResponseStatus(HttpStatus.OK)
    PlayerDto deletePlayer(@PathVariable(name = "player_id", required = true) final UUID playerId) {
        return playerMapper.mapTo(playerService.delete(playerId));
    }

    @GetMapping("/{player_id}")
    @ResponseStatus(HttpStatus.OK)
    PlayerDto getPlayerById(@PathVariable(name = "player_id", required = true) final UUID playerId) {
        return playerMapper.mapTo(playerService.getById(playerId));
    }
}
