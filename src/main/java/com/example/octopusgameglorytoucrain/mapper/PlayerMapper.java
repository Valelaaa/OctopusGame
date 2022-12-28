package com.example.octopusgameglorytoucrain.mapper;

import com.example.octopusgameglorytoucrain.entity.Player;
import com.example.octopusgameglorytoucrain.entity.dto.PlayerDto;
import org.springframework.stereotype.Service;

@Service
@org.mapstruct.Mapper
public interface PlayerMapper extends Mapper<Player, PlayerDto>{
}
