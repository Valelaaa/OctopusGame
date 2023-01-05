package com.example.octopusgameglorytoucrain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnswerDto {
    @NotBlank
    private String answer;
    private Boolean isCorrect;
}
