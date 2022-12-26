package com.example.octopusgameglorytoucrain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "t_players")
public class Player {
    @Id
    @Column(name = "player_id")
    private UUID id;
}
