package hu.nye.progenv.service;

import java.util.List;

import hu.nye.progenv.controller.model.LessonRequest;
import hu.nye.progenv.controller.model.LessonResponse;
import org.springframework.stereotype.Service;

/**
 * Lesson service interface.
 */
@Service
public interface LessonInterface {

    public LessonResponse createLesson(LessonRequest lesson);

    public LessonResponse getLesson(Long id);

    public List<LessonResponse> getAllLessons();

    public List<LessonResponse> getLessonsByName(String name);

    public LessonResponse updateLesson(Long id, LessonRequest lesson);


    public void deleteLesson(Long id);

}
