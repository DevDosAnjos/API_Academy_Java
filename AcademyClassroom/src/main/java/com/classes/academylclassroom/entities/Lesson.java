package com.classes.academylclassroom.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank(message = "Field cannot be blank.")
    private String lessonName;
    @NotBlank(message = "Field cannot be blank.")
    private String modality;
    @NotBlank(message = "Field cannot be blank.")
    private String room;
    @NotBlank(message = "Field cannot be blank.")
    private LocalDateTime hours;
    @NotBlank(message = "Field cannot be blank.")
    private Duration duration;

    public Lesson() {
    }

    public Lesson(String lessonName, String modality, String room, LocalDateTime hours, Duration duration) {
        this.lessonName = lessonName;
        this.modality = modality;
        this.room = room;
        this.hours = hours;
        this.duration = duration;
    }
}
