package hu.nye.progenv.service;

import org.springframework.beans.factory.annotation.Autowired;

import hu.nye.progenv.repository.RepositoryInterface;
import hu.nye.progenv.repository.DBEntity.Lesson;
import hu.nye.progenv.service.model.LessonRequest;
import hu.nye.progenv.service.model.LessonResponse;

public class LessonService implements LessonInterface {
    
    
    @Autowired
    private RepositoryInterface repository;
    
    @Override
    public LessonResponse createLesson(LessonRequest lesson) {
        Lesson lessonEntity = Lesson.builder()
            .name(lesson.getName())
            .startTime(lesson.getStartTime())
            .stopTime(lesson.getStopTime())
            .room(lesson.getRoom())
            .build();
        Lesson result = repository.save(lessonEntity);
        return LessonResponse.builder()
            .name(result.getName())
            .startTime(result.getStartTime())
            .stopTime(result.getStopTime())
            .room(result.getRoom())
            .build();
    }
}
