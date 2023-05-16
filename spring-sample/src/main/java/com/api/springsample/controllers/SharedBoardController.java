package com.api.springsample.controllers;

import com.api.springsample.dtos.SharedBoardDTO;
import com.api.springsample.models.SharedBoardModel;
import com.api.springsample.services.SharedBoardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/spring-sample") // http://localhost:8080/spring-sample
public class SharedBoardController {

    // Criar pomto de injeçao do service a partir aqui do controller
    // via construtor, ou via @Autowired
    @Autowired
    SharedBoardService sharedBoardService;

    /**
     * Metodos POST, GET, GET by ID, DELETE by ID, PUT by ID
     * p/ experimentar no PostMan
     * @param sharedBoardDTO
     * @return
     */

    // Metodo POST

    @PostMapping
    public ResponseEntity<Object> saveSharedBoard(
            @RequestBody SharedBoardDTO sharedBoardDTO) {

        if (sharedBoardService.existsByTitle(sharedBoardDTO.getTitle())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("SB already exists");
        }

        var sbModel = new SharedBoardModel();
        // Converter um DTO em Model com BeanUtils:
        BeanUtils.copyProperties(sharedBoardDTO, sbModel);
        sbModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(sharedBoardService.save(sbModel));
    }

    // Metodo GET

    @GetMapping
    public ResponseEntity<List<SharedBoardModel>> getAllSharedBoards() {
        return ResponseEntity.status(HttpStatus.OK).body(sharedBoardService.findAll());
    }

    // Metodo GET by ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getOneSharedBoard(@PathVariable(value = "id") UUID id) {
        Optional<SharedBoardModel> optionalSharedBoardModel = sharedBoardService.findById(id);
        if (!optionalSharedBoardModel.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shared board not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalSharedBoardModel.get());
    }

    // Metodo DELETE by ID
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteSharedBoard(@PathVariable(value = "id") UUID id) {
        Optional<SharedBoardModel> optionalSharedBoardModel = sharedBoardService.findById(id);
        if (!optionalSharedBoardModel.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shared board not found");
        }
        sharedBoardService.delete(optionalSharedBoardModel.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Metodo PUT by ID
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateSharedBoard(@PathVariable(value = "id") UUID id, @RequestBody SharedBoardDTO sharedBoardDTO) {
        Optional<SharedBoardModel> optionalSharedBoardModel = sharedBoardService.findById(id);
        if (!optionalSharedBoardModel.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shared board not found");
        }

        var sharedBoardModel = new SharedBoardModel();  // Only a test
        BeanUtils.copyProperties(sharedBoardDTO, sharedBoardModel);
        sharedBoardModel.setRegistrationDate(optionalSharedBoardModel.get().getRegistrationDate());
        sharedBoardModel.setId(optionalSharedBoardModel.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(sharedBoardService.save(sharedBoardModel));

    }

}
