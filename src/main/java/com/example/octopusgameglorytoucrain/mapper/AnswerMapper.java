package com.example.octopusgameglorytoucrain.mapper;

import com.example.octopusgameglorytoucrain.entity.Answer;
import com.example.octopusgameglorytoucrain.entity.dto.AnswerDto;
import org.mapstruct.Mapping;

import java.util.List;

@org.mapstruct.Mapper
public interface AnswerMapper extends Mapper<Answer, AnswerDto> {
    List<Answer> mapToList(List<AnswerDto> answerDtos);
    List<AnswerDto> mapFromList(List<Answer> answers);
    @Mapping(source = "answer", target = "answer")
    @Mapping(source = "isCorrect",target = "isCorrect")
    AnswerDto mapTo(Answer object);
}
