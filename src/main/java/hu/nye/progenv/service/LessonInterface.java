package hu.nye.progenv.service;

import hu.nye.progenv.controller.model.LessonRequest;
import hu.nye.progenv.controller.model.LessonResponse;

import org.springframework.stereotype.Service;

@Service
public interface LessonInterface {

    public LessonResponse createLesson(LessonRequest lesson);

    public LessonResponse getLesson(Long id);

    public LessonResponse updateLesson(Long id, LessonRequest lesson);

    public void deleteLesson(Long id);

}
