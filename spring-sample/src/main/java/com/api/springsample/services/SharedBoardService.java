package com.api.springsample.services;

import com.api.springsample.models.SharedBoardModel;
import com.api.springsample.repositories.SharedBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SharedBoardService {

    // Injecao de dependencia de um repository dentro de um service
    @Autowired
    SharedBoardRepository sbRepository;

    @Transactional
    public SharedBoardModel save(SharedBoardModel sbModel) {
        return sbRepository.save(sbModel);
    }

    public boolean existsByTitle(String title) {
        return sbRepository.existsByTitle(title);
    }

    public List<SharedBoardModel> findAll() {
        return sbRepository.findAll();
    }

    public Optional<SharedBoardModel> findById(UUID id) {
        return sbRepository.findById(id);
    }

    public void delete(SharedBoardModel sbModel) {
        sbRepository.delete(sbModel);
    }
}
