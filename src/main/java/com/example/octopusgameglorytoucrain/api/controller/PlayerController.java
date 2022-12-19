package com.example.octopusgameglorytoucrain.api.controller;

import com.example.octopusgameglorytoucrain.entity.Player;
import com.example.octopusgameglorytoucrain.entity.dto.PlayerDto;
import com.example.octopusgameglorytoucrain.mapper.Mapper;
import com.example.octopusgameglorytoucrain.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    private final Mapper<Player,PlayerDto> playerMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PlayerDto> getPlayers(){
        return playerService.getAll().stream()
                            .map(playerMapper::mapTo)
                            .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PlayerDto createPlayer(){
        return playerMapper.mapTo(playerService.save(UUID.randomUUID()));
    }

    @DeleteMapping("/{player_id}")
    @ResponseStatus(HttpStatus.OK)
    PlayerDto deletePlayer(@PathVariable(name = "player_id", required = true) final UUID player_id){
        return playerMapper.mapTo(playerService.delete(player_id));
    }
    @GetMapping("/{player_id}")
    @ResponseStatus(HttpStatus.OK)
    PlayerDto getPlayerById(@PathVariable(name = "player_id", required = true) final UUID player_id) {
        return playerMapper.mapTo(playerService.getById(player_id));
    }
}
