package hu.nye.progenv.service;

import hu.nye.progenv.controller.model.LessonRequest;
import hu.nye.progenv.controller.model.LessonResponse;
import hu.nye.progenv.dao.DBEntity.Lesson;
import hu.nye.progenv.dao.RepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.configuration.GlobalConfiguration.validate;

@Slf4j
class LessonServiceTest {


    LessonService  underTest;

    @Mock
    RepositoryInterface repositoryInterface;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new LessonService(repositoryInterface);

    }

    @Test
    void createLesson() {
        // given
        Lesson lesson = Lesson.builder()
                .name("name")
                .startTime(LocalDateTime.now())
                .stopTime(LocalDateTime.now())
                .room("room")
                .build();
        when(repositoryInterface.save(any())).thenReturn(lesson);
        LessonRequest request = new LessonRequest().builder()
                .name("name")
                .startTime(LocalDateTime.now())
                .stopTime(LocalDateTime.now())
                .build();
        // when
        underTest.createLesson(request);
        // then
        verify(repositoryInterface).save(any());
    }


    @Test
    void getAllLessonsNoError() {
//        // given
//        log.info("getAllLessonsNoError");
//        when(repositoryInterface.findAll()).thenReturn(any());
//        // when
//        repositoryInterface.findAll();
//        // then
//        verify(repositoryInterface).findAll();
    }
}