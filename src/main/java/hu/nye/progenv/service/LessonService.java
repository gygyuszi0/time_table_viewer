package hu.nye.progenv.service;

import hu.nye.progenv.CustomExceptions.LessonNotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import hu.nye.progenv.repository.RepositoryInterface;
import hu.nye.progenv.repository.DBEntity.Lesson;
import hu.nye.progenv.controller.model.LessonRequest;
import hu.nye.progenv.controller.model.LessonResponse;
import org.springframework.stereotype.Service;

@Service
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

    @Override
    @SneakyThrows
    public LessonResponse getLesson(Long id) {
        Lesson lesson = repository.findById(id).orElseThrow(LessonNotFoundException::new);
        LessonResponse response = LessonResponse.builder()
            .name(lesson.getName())
            .startTime(lesson.getStartTime())
            .stopTime(lesson.getStopTime())
            .room(lesson.getRoom())
            .build();
        return response;
    }

    @Override
    @SneakyThrows
    public LessonResponse updateLesson(Long id, LessonRequest lesson) {
        Lesson lessonEntity = repository.findById(id).orElseThrow(LessonNotFoundException::new);
        lessonEntity.setName(lesson.getName());
        lessonEntity.setStartTime(lesson.getStartTime());
        lessonEntity.setStopTime(lesson.getStopTime());
        lessonEntity.setRoom(lesson.getRoom());
        Lesson result = repository.save(lessonEntity);
        return LessonResponse.builder()
            .name(result.getName())
            .startTime(result.getStartTime())
            .stopTime(result.getStopTime())
            .room(result.getRoom())
            .build();
    }

    @Override
    public void deleteLesson(Long id) {
        repository.deleteById(id);
    }


}
