package com.example.octopusgameglorytoucrain.service.Impl;

import com.example.octopusgameglorytoucrain.entity.Player;
import com.example.octopusgameglorytoucrain.repository.PlayerRepository;
import com.example.octopusgameglorytoucrain.repository.WinnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerServiceImplTest {
    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private WinnerRepository winnerRepository;
    @InjectMocks
    private PlayerServiceImpl playerService;
    private static final List<Player> PLAYER_LIST = List.of(
            new Player(UUID.randomUUID()), new Player(UUID.randomUUID()), new Player(UUID.randomUUID())
    );

    @Test
    void getAllShouldSucceed() {
        //Given

        //When
        when(playerRepository.findAll()).thenReturn(PLAYER_LIST);
        final List<Player> destinationList = playerService.getAll();

        //Then
        assertThat(playerService.getAll()).isEqualTo(playerRepository.findAll());
        assertThat(playerService.getAll()).hasSameElementsAs(playerRepository.findAll());


        assertEquals(PLAYER_LIST, destinationList);
        assertArrayEquals(PLAYER_LIST.toArray(),destinationList.toArray());
    }
}