package com.example.octopusgameglorytoucrain.mapper;

import com.example.octopusgameglorytoucrain.api.exceptions.PlayerNotFoundException;
import com.example.octopusgameglorytoucrain.entity.Winner;
import com.example.octopusgameglorytoucrain.entity.dto.WinnerDto;
import com.example.octopusgameglorytoucrain.repository.WinnerRepository;
import org.springframework.stereotype.Service;

@Service

public class WinnerMapperImpl implements Mapper<Winner, WinnerDto> {
    WinnerRepository winnerRepository;
    @Override
    public Winner mapFrom(WinnerDto object) {
        if (winnerRepository.findByNickname(object.getNickname()).isPresent())
            return new Winner(winnerRepository.findByNickname(object.getNickname()).get().getWinnerId(),
                object.getNickname(), object.getWinDate());
        throw new PlayerNotFoundException(object.getNickname());
    }
    @Override
    public WinnerDto mapTo(final Winner object) {
        return new WinnerDto(object.getWinnerId(),object.getNickname(),object.getWinDate());
    }
}
