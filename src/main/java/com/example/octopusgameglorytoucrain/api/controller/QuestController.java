package com.example.octopusgameglorytoucrain.api.controller;

import com.example.octopusgameglorytoucrain.entity.Quest;
import com.example.octopusgameglorytoucrain.entity.dto.QuestDto;
import com.example.octopusgameglorytoucrain.mapper.Mapper;
import com.example.octopusgameglorytoucrain.mapper.QuestMapper;
import com.example.octopusgameglorytoucrain.service.QuestService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quests")
@Slf4j
@CrossOrigin
public class QuestController {
    private final QuestService questService;
    private final Mapper<Quest, QuestDto> questMapper = Mappers.getMapper(QuestMapper.class);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public QuestDto saveQuest(@RequestBody(required = true) final QuestDto questDto) {
        final Quest quest = questMapper.mapFrom(questDto);

        quest.setIsActive(true);
        quest.setAddedAt(LocalDate.now());
        QuestDto returnValue = questMapper.mapTo(questService.save(quest));
        log.info(""+returnValue);
        return returnValue;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<QuestDto> getAllQuests() {
        return questService.getAllQuests().stream().map(questMapper::mapTo).toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{questId}")
    public QuestDto getQuestById(@PathVariable(name = "questId") final UUID questId) {
        log.info(String.valueOf(questId));
        return questMapper.mapTo(questService.getById(questId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{questId}")
    public QuestDto deleteQuestById(@PathVariable (name="questId") final UUID id) {
        return questMapper.mapTo(questService.deleteById(id));
    }

    @ResponseStatus(HttpStatus.UPGRADE_REQUIRED)
    @PatchMapping("/{questId}")
    public QuestDto updateById(@PathVariable(name = "questId", required = true) final UUID id, @RequestBody(required = true) final QuestDto questDto) {
        final Quest quest = questMapper.mapFrom(questDto);
        quest.setIsActive(true);
        return questMapper.mapTo(questService.updateById(id, quest));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/returnQuests")
    public List<QuestDto> returnAllQuests() {
        return questService.returnAllQuests().stream().map(questMapper::mapTo).toList();
    }
}
