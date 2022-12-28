package com.example.octopusgameglorytoucrain.service.Impl;

import com.example.octopusgameglorytoucrain.api.exceptionHandler.exceptions.QuestNotFoundException;
import com.example.octopusgameglorytoucrain.entity.Answer;
import com.example.octopusgameglorytoucrain.entity.Quest;
import com.example.octopusgameglorytoucrain.repository.AnswerRepository;
import com.example.octopusgameglorytoucrain.repository.QuestRepository;
import com.example.octopusgameglorytoucrain.service.QuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class QuestServiceImpl implements QuestService {
    private final QuestRepository questRepository;
    private final AnswerRepository answerRepository;

    @Override
    public Quest save(final Quest quest) {
        final List<Answer> answers = quest.getAnswers();
        quest.setQuestId(UUID.randomUUID());
        answers.forEach(answer -> {
            answer.setAnswerId(UUID.randomUUID());
        });
        final Quest quest1 = questRepository.save(quest);
        answers.forEach(answer -> {
            answer.setQuestId(quest.getQuestId());
        });
        answerRepository.saveAll(answers);

        quest1.setAnswers(answerRepository.getAnswerByQuestId(quest1.getQuestId()));
        return questRepository.save(quest1);
    }

    @Override
    public Quest getById(final UUID questID) {
        return questRepository.findByQuestIdAndIsActiveIsTrue(questID)
                .orElseThrow(() -> new QuestNotFoundException("Quest not found"));

    }

    @Override
    public Quest deleteById(UUID questId) {
        final Quest quest = questRepository.findByQuestIdAndIsActiveIsTrue(questId)
                .orElseThrow(() -> new QuestNotFoundException("Quest not found"));
        quest.setIsActive(false);
        return questRepository.save(quest);
    }

    @Override
    public List<Quest> getAllQuests() {
        return questRepository.findAllByIsActiveIsTrue();
    }

    @Override
    public Quest updateById(UUID questID, Quest questDto) {
        final Quest quest = questRepository.findByQuestIdAndIsActiveIsTrue(questID)
                .orElseThrow(() -> new QuestNotFoundException("Quest not found"));
        quest.setQuestText(questDto.getQuestText());
        quest.setAnswers(questDto.getAnswers());
        return questRepository.save(quest);
    }

    @Override
    public List<Quest> returnAllQuests() {
        final List<Quest> list = questRepository.findAllByIsActiveIsTrue();
        list.forEach(quest -> quest.setIsActive(true));
        return questRepository.saveAll(list);
    }
}
