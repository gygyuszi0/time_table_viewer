package hu.nye.progenv.service;

import java.util.List;

import hu.nye.progenv.CustomExceptions.LessonNotFoundException;
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

    LessonService underTest;

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
        verify(repositoryInterface).save(any());
    }

    @Test
    void getLessonNoError() {
        log.info("Case\t:Get lesson without error");
        // given
        Lesson lesson = Lesson.builder()
                .name("teszt")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt")
                .build();
        when(repositoryInterface.findById(any())).thenReturn(java.util.Optional.of(lesson));
        LessonResponse expected = LessonResponse.builder()
                .name("teszt")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt")
                .build();
        // when
        LessonResponse result = underTest.getLesson(1L);
        // then
        verify(repositoryInterface).findById(1L);
        assertEquals(expected, result);
    }

    @Test
    void getLessonError() {
        log.info("Case\t:Get lesson with error");
        // given
        when(repositoryInterface.findById(any())).thenReturn(java.util.Optional.empty());
        // when - then
        assertThrows(LessonNotFoundException.class, () -> underTest.getLesson(1L));
        verify(repositoryInterface).findById(1L);
    }

    @Test
    void getAllLessonsNoError() {
        log.info("Case\t:Get all lessons without error");
        // given
        Lesson lesson = Lesson.builder()
                .name("teszt")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt")
                .build();
        when(repositoryInterface.findAll()).thenReturn(java.util.List.of(lesson));
        LessonResponse expected_lesson = LessonResponse.builder()
                .name("teszt")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt")
                .build();
        List<LessonResponse> expected = List.of(expected_lesson);
        // when
        List<LessonResponse> result = underTest.getAllLessons();

        // then
        verify(repositoryInterface).findAll();
        assertEquals(expected, result);
    }

    @Test
    void getAllLessonsEmpty() {
        log.info("Case\t:Get all lessons empty response");
        // given
        when(repositoryInterface.findAll()).thenReturn(java.util.List.of());
        List<LessonResponse> expected = List.of();
        // when
        List<LessonResponse> result = underTest.getAllLessons();
        // then
        verify(repositoryInterface).findAll();
        assertEquals(expected, result);
    }

    @Test
    void getLessonsByNameNoError() {
        log.info("Case\t: Get all lesson with name teszt, no error");
        // given
        Lesson lesson = Lesson.builder()
                .name("teszt")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt")
                .build();
        when(repositoryInterface.findAllByName("teszt")).thenReturn(java.util.List.of(lesson));
        LessonResponse expected_lesson = LessonResponse.builder()
                .name("teszt")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt")
                .build();
        List<LessonResponse> expected = List.of(expected_lesson);
        // when
        List<LessonResponse> result = underTest.getLessonsByName("teszt");
        // then
        verify(repositoryInterface).findAllByName("teszt");
        assertEquals(expected, result);
    }

    @Test
    void getLessonsByNameEmpty() {
        log.info("Case\t: Get all lesson with name teszt, empty response");
        // given
        when(repositoryInterface.findAllByName("teszt")).thenReturn(java.util.List.of());
        List<LessonResponse> expected = List.of();
        // when
        List<LessonResponse> result = underTest.getLessonsByName("teszt");
        // then
        verify(repositoryInterface).findAllByName("teszt");
        assertEquals(expected, result);
    }

    @Test
    void updateLessonNoError() {
        log.info("Case\t: Update lesson without error");
        // given
        Lesson lesson_old = Lesson.builder()
                .name("teszt")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt")
                .build();
        when(repositoryInterface.findById(any())).thenReturn(java.util.Optional.of(lesson_old));

        Lesson lesson_new = Lesson.builder()
                .name("teszt2")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt2")
                .build();
        when(repositoryInterface.save(any())).thenReturn(lesson_new);
        
        LessonRequest request = LessonRequest.builder()
                .name("teszt2")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt2")
                .build();
        long id = 1L;
        
        LessonResponse expected = LessonResponse.builder()
                .name("teszt2")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt2")
                .build();
        // when
        LessonResponse result = underTest.updateLesson(id, request);
        // then
        verify(repositoryInterface).findById(id);
        verify(repositoryInterface).save(lesson_new);
        assertEquals(expected, result);
    }

    @Test
    void updateLessonError() {
        log.info("Case\t: Update lesson with error");
        // given
        LessonRequest request = LessonRequest.builder()
                .name("teszt2")
                .startTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .stopTime(LocalDateTime.of(1, 2, 3, 4, 5, 6))
                .room("teszt2")
                .build();
        long id = 1L;
        when(repositoryInterface.findById(any())).thenReturn(java.util.Optional.empty());
        // when - then
        assertThrows(LessonNotFoundException.class, () -> underTest.updateLesson(id, request));
        verify(repositoryInterface).findById(id);
    }

    @Test
    void deleteLesson() {
        log.info("Case\t: Delete lesson");
        // given
        long id = 1L;
        // when
        underTest.deleteLesson(id);
        // then
        verify(repositoryInterface).deleteById(id);
    }
}