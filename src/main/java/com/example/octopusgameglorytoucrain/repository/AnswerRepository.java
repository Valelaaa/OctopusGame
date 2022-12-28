package com.example.octopusgameglorytoucrain.repository;

import com.example.octopusgameglorytoucrain.entity.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, UUID> {
    List<Answer> getAnswerByQuestId(final UUID id);
}
