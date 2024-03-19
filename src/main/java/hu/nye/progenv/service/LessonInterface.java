package hu.nye.progenv.service;

import hu.nye.progenv.service.model.LessonRequest;
import hu.nye.progenv.service.model.LessonResponse;

import org.springframework.stereotype.Service;

@Service
public interface LessonInterface {

    public LessonResponse createLesson(LessonRequest lesson);

}
