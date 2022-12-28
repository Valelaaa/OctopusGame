package com.example.octopusgameglorytoucrain.service;

import com.example.octopusgameglorytoucrain.entity.Quest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface QuestService {
    Quest save(final Quest quest);
    Quest getById(final UUID questID);
    Quest deleteById(final UUID questId);
    List<Quest> getAllQuests();

    Quest updateById(final UUID questID, Quest questDto);

    List<Quest> returnAllQuests();
}
