package com.example.octopusgameglorytoucrain.mapper;

import com.example.octopusgameglorytoucrain.entity.Quest;
import com.example.octopusgameglorytoucrain.entity.dto.QuestDto;
import org.springframework.stereotype.Service;

@org.mapstruct.Mapper(uses = AnswerMapper.class)
@Service
public interface QuestMapper extends Mapper<Quest, QuestDto> {

}
