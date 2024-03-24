package hu.nye.progenv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import hu.nye.progenv.service.LessonInterface;
import hu.nye.progenv.service.model.LessonRequest;
import hu.nye.progenv.service.model.LessonResponse;

@RestController
public class LessonControl {

    @Autowired
    private LessonInterface lessonService;

    @PostMapping("/create_lesson")    
    public LessonResponse createLesson(@RequestBody LessonRequest lesson) {
        return lessonService.createLesson(lesson);
    }

    @GetMapping("/get_lesson/{id}")
    public LessonResponse getLesson(@PathVariable("id") Long id) {
        return lessonService.getLesson(id);
    }
}
