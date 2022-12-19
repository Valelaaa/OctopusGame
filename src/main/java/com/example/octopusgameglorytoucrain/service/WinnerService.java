package com.example.octopusgameglorytoucrain.service;

import com.example.octopusgameglorytoucrain.entity.Winner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface WinnerService {
    List<Winner> getAll();

    public Winner create(final UUID player, final String nickname);

}
