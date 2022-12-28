package com.example.octopusgameglorytoucrain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "t_quests")
public class Quest {
    @Id
    @Column(name = "quest_id")
    private UUID questId;
    @Column(name = "quest_text")
    private String questText;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "added_at")
    private LocalDate addedAt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ans_quest_id")
    private List<Answer> answers;
}
