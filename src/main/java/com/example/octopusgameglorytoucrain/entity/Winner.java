package com.example.octopusgameglorytoucrain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "t_winners")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Winner {
    @Id
    @Column(name = "winner_id")
    private UUID winnerId;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "win_date")
    private LocalDate winDate;

}
