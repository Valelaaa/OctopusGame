package com.example.octopusgameglorytoucrain.api.controller;

import com.example.octopusgameglorytoucrain.entity.Winner;
import com.example.octopusgameglorytoucrain.entity.dto.WinnerDto;
import com.example.octopusgameglorytoucrain.mapper.Mapper;
import com.example.octopusgameglorytoucrain.mapper.WinnerMapper;
import com.example.octopusgameglorytoucrain.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/winners")
public class WinnerController {
    private final WinnerService winnerService;
    private final Mapper<Winner, WinnerDto> winnerMapper = Mappers.getMapper(WinnerMapper.class);

    @GetMapping
    List<WinnerDto> getAllWinners() {
        return winnerService.getAll().stream().map(winnerMapper::mapTo).collect(Collectors.toList());
    }

    @PostMapping
    WinnerDto createWinner(@RequestParam(name = "player_id", required = true) UUID player_id, @RequestParam(name = "nickname", required = false) String nickname) {
        return winnerMapper.mapTo(winnerService.create(player_id, nickname));
    }

}
