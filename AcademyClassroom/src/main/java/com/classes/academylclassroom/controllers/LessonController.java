package com.classes.academylclassroom.controllers;


import com.classes.academylclassroom.services.LessonService;
import com.classes.academylclassroom.dto.LessonsRequest;
import com.classes.academylclassroom.dto.LessonsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping("/date")
    public ResponseEntity<LessonsResponse> get(String id){
        LessonsResponse response = lessonService.getClasses(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LessonsResponse>> listAll(){
        List<LessonsResponse> responses = lessonService.listAllClasses();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<LessonsResponse> create(LessonsRequest lessonsRequest){
        LessonsResponse response = lessonService.creatClass(lessonsRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonsResponse> update(@PathVariable("id") String id, LessonsRequest lessonsRequest){
        LessonsResponse response = lessonService.updateClass(id, lessonsRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LessonsResponse> delete(@PathVariable("id") String id){
        LessonsResponse response = lessonService.deleteClass(id);
        return ResponseEntity.ok(response);
    }
}
