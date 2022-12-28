package com.example.octopusgameglorytoucrain.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestDto {
    @NotNull
    private UUID questId;
    @NotBlank
    private String questText;
    @NotNull
    private List<AnswerDto> answers;
}
