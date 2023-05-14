package com.api.springsample.repositories;

import com.api.springsample.models.SharedBoardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SharedBoardRepository extends JpaRepository<SharedBoardModel, UUID> {

    public boolean existsByTitle(String title);
}