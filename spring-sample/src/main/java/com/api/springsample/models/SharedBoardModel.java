package com.api.springsample.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class SharedBoardModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String title;
    @Column(nullable = false, length = 130)
    private String description;
    @Column(nullable = false)
    private LocalDateTime registrationDate;

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String responsibleName) {
        this.description = responsibleName;
    }

}
