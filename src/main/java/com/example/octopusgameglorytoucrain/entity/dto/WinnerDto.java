package com.example.octopusgameglorytoucrain.entity.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class WinnerDto {
    @NotNull
    @Id
    private UUID id;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{4,10}$")
    private String nickname;
    @NotNull
    private LocalDate winDate;
}
