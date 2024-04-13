package hu.nye.progenv.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import hu.nye.progenv.service.LessonInterface;
import hu.nye.progenv.controller.model.LessonRequest;
import hu.nye.progenv.controller.model.LessonResponse;

import java.util.List;

@RestController
public class LessonControl {

    @Autowired
    private LessonInterface lessonService;

    @PostMapping("/create_lesson")    
    public LessonResponse createLesson(@RequestBody @Valid LessonRequest lesson) {
        return lessonService.createLesson(lesson);
    }

    @GetMapping("/get_lesson/{id}")
    public LessonResponse getLesson(@PathVariable("id") Long id) {
        return lessonService.getLesson(id);
    }

    @GetMapping("/get_all_lessons")
    public List<LessonResponse> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @DeleteMapping("/delete_lesson/{id}")
    public void deleteLesson(@PathVariable("id") Long id) {
        lessonService.deleteLesson(id);
    }

    @PutMapping("/update_lesson/{id}")
    public LessonResponse updateLesson(@PathVariable("id") Long id, @RequestBody @Valid LessonRequest lesson) {
        return lessonService.updateLesson(id, lesson);
    }

}
