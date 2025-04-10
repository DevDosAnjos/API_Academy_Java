package com.classes.academylclassroom.services;

import com.classes.academylclassroom.entities.Lesson;
import com.classes.academylclassroom.repositories.LessonRepository;
import com.classes.academylclassroom.dto.LessonsRequest;
import com.classes.academylclassroom.dto.LessonsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;


    public LessonsResponse getClasses(String id) {
        Optional<Lesson> optionalClass = lessonRepository.findById(id);
        if (optionalClass.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Class id not found");
        }
        return new LessonsResponse(
                optionalClass.get().getId(),
                optionalClass.get().getLessonName(),
                optionalClass.get().getModality(),
                optionalClass.get().getRoom(),
                optionalClass.get().getHours(),
                optionalClass.get().getDuration()
        );
    }

    public List<LessonsResponse> listAllClasses() {
        List<Lesson> lessons = lessonRepository.findAll();
        return LessonsResponse.fromClasses(lessons);
    }

    public LessonsResponse creatClass(LessonsRequest lessonsRequest) {
        Lesson aLesson = new Lesson(lessonsRequest.lessonName(), lessonsRequest.modality(), lessonsRequest.room(), lessonsRequest.hours(), lessonsRequest.duration());
        lessonRepository.save(aLesson);
        return new LessonsResponse(
                aLesson.getId(),
                aLesson.getLessonName(),
                aLesson.getModality(),
                aLesson.getRoom(),
                aLesson.getHours(),
                aLesson.getDuration()
        );
    }

    public LessonsResponse updateClass(String id, LessonsRequest lessonsRequest) {
        Optional<Lesson> optionalClass = lessonRepository.findById(id);
        if (optionalClass.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Class id not found");
        }
        if (lessonsRequest.modality() != null){
            optionalClass.get().setModality(lessonsRequest.modality());
        }
        if (lessonsRequest.room() != null){
            optionalClass.get().setRoom(lessonsRequest.room());
        }
        if (lessonsRequest.hours() != null){
            optionalClass.get().setHours(lessonsRequest.hours());
        }
        if (lessonsRequest.duration() != null){
            optionalClass.get().setDuration(lessonsRequest.duration());
        }
        lessonRepository.saveAndFlush(optionalClass.get());
        return new LessonsResponse(
                optionalClass.get().getId(),
                optionalClass.get().getLessonName(),
                optionalClass.get().getModality(),
                optionalClass.get().getRoom(),
                optionalClass.get().getHours(),
                optionalClass.get().getDuration()
        );
    }

    public LessonsResponse deleteClass(String id) {
        Optional<Lesson> optionalClass = lessonRepository.findById(id);
        if (optionalClass.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensality id not found");
        }
        Lesson aLesson = optionalClass.get();
        lessonRepository.delete(aLesson);
        return new LessonsResponse(
                optionalClass.get().getId(),
                optionalClass.get().getLessonName(),
                optionalClass.get().getModality(),
                optionalClass.get().getRoom(),
                optionalClass.get().getHours(),
                optionalClass.get().getDuration()
        );
    }

}
