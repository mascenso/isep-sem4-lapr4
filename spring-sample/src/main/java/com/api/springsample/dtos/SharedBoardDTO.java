package com.api.springsample.dtos;

import lombok.Data;

public @Data class SharedBoardDTO {

    private String title;
    private String description;

    // A anotacao @Data do Lombok gera automaticamente os getters e setters, ver o controller
}
