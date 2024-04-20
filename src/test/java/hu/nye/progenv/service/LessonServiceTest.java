package hu.nye.progenv.service;

import hu.nye.progenv.controller.model.LessonRequest;
import hu.nye.progenv.controller.model.LessonResponse;
import hu.nye.progenv.dao.DBEntity.Lesson;
import lombok.extern.slf4j.Slf4j;
import hu.nye.progenv.dao.RepositoryInterface;
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
    void createLessonNoError() {
        log.info("Case\t:Create lesson without error");
        // given
        Lesson lesson = Lesson.builder()
            .name("teszt")
            .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
            .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
            .room("teszt")
            .build();
        when(repositoryInterface.save(any())).thenReturn(lesson);

        LessonRequest request = LessonRequest.builder()
            .name("teszt")
            .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
            .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
            .room("teszt")
            .build();
        LessonResponse expected = LessonResponse.builder()
            .name("teszt")
            .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
            .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
            .room("teszt")
            .build();
        // when
        LessonResponse result = underTest.createLesson(request);
        // then
        verify(repositoryInterface).save(lesson);
        assertEquals(expected, result);
    }

    @Test
    void createLessonError() {
        log.info("Case\t:Create lesson with error");
        // given
        when(repositoryInterface.save(any())).thenReturn(null);
        LessonRequest request = LessonRequest.builder()
            .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
            .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
            .room("teszt")
            .build();
        // when - then
        assertThrows(NullPointerException.class, () -> underTest.createLesson(request));
    }
}