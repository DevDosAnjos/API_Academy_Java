package com.classes.academylclassroom.dto;

import com.classes.academylclassroom.entities.Lesson;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public record LessonsResponse(
        String id,
        String lessonName,
        String modality,
        String room,
        LocalDateTime hours,
        Duration duration
) {
    public static List<LessonsResponse> fromClasses(List<Lesson> lessons) {
        return lessons.stream().map(lesson -> new LessonsResponse(
                lesson.getId(),
                lesson.getLessonName(),
                lesson.getModality(),
                lesson.getRoom(),
                lesson.getHours(),
                lesson.getDuration()
        )).toList();
    }
}
