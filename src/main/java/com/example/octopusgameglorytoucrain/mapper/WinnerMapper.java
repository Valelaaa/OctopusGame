package com.example.octopusgameglorytoucrain.mapper;

import com.example.octopusgameglorytoucrain.entity.Winner;
import com.example.octopusgameglorytoucrain.entity.dto.WinnerDto;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@org.mapstruct.Mapper
@Service
public interface WinnerMapper extends Mapper<Winner, WinnerDto> {
    @Override
    @Mapping(source = "winnerId", target = "id")
    WinnerDto mapTo(Winner object);
}
