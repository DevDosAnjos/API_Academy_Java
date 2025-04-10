package com.classes.academylclassroom.dto;

import java.time.Duration;
import java.time.LocalDateTime;

public record LessonsRequest(
        String lessonName,
        String modality,
        String room,
        LocalDateTime hours,
        Duration duration
) {
}
