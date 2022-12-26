package com.example.octopusgameglorytoucrain.service.Impl;

import com.example.octopusgameglorytoucrain.api.exceptions.PlayerNotFoundException;
import com.example.octopusgameglorytoucrain.entity.Player;
import com.example.octopusgameglorytoucrain.entity.Winner;
import com.example.octopusgameglorytoucrain.repository.PlayerRepository;
import com.example.octopusgameglorytoucrain.repository.WinnerRepository;
import com.example.octopusgameglorytoucrain.service.WinnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WinnerServiceImpl implements WinnerService {
    private final WinnerRepository winnerRepository;

    @Override
    public List<Winner> getAll() {
        return (List<Winner>) winnerRepository.findAll();
    }

    @Override
    public Winner create(final UUID player, final String nickname) {
        final Winner winner = new Winner(player, nickname, LocalDate.now());
        return winnerRepository.save(winner);
    }
}
