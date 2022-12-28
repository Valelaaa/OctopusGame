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
@Setter
@Getter
@ToString
@Table(name = "t_answers")
public class Answer {
    @Id
    @Column(name = "answer_id")
    private UUID answerId;
    @Column(name = "answer")
    private String answer;
    @Column(name = "is_correct")
    private Boolean isCorrect;
    @Column(name = "ans_quest_id")
    private UUID questId;
}
