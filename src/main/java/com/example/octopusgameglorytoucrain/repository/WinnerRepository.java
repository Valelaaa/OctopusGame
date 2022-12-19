package com.example.octopusgameglorytoucrain.repository;

import com.example.octopusgameglorytoucrain.entity.Winner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface WinnerRepository extends CrudRepository<Winner, UUID> {
    Optional<Winner> findByNickname(final String nickname);
}
