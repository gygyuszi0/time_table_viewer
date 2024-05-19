package hu.nye.progenv.controller;

import java.util.List;

import hu.nye.progenv.controller.model.LessonRequest;
import hu.nye.progenv.controller.model.LessonResponse;
import hu.nye.progenv.service.LessonInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Lesson.
 */
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

    @GetMapping("/get_lesson_by_name/{name}")
    public List<LessonResponse> getLessonByName(@PathVariable("name") String name) {
        return lessonService.getLessonsByName(name);
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
