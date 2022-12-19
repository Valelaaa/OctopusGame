package com.example.octopusgameglorytoucrain.mapper;

import com.example.octopusgameglorytoucrain.entity.Player;
import com.example.octopusgameglorytoucrain.entity.dto.PlayerDto;
import org.springframework.stereotype.Service;

@Service
public class PlayerMapperImpl implements Mapper<Player, PlayerDto>{

    @Override
    public Player mapFrom(PlayerDto object) {
        return new Player(object.getId());
    }

    @Override
    public PlayerDto mapTo(Player object) {
        return new PlayerDto(object.getId());
    }
}
