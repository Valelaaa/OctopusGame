package com.example.octopusgameglorytoucrain.mapper;

import com.example.octopusgameglorytoucrain.entity.Winner;
import com.example.octopusgameglorytoucrain.entity.dto.WinnerDto;
import org.springframework.stereotype.Service;

@org.mapstruct.Mapper
@Service
public interface WinnerMapper extends Mapper<Winner, WinnerDto> {
}
