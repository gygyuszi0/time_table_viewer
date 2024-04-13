package hu.nye.progenv.service;

import hu.nye.progenv.controller.model.LessonRequest;
import hu.nye.progenv.dao.DBEntity.Lesson;
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
        when(repositoryInterface.save(any())).thenReturn(any());
        Lesson request = new Lesson();
        request.setName("test");
        request.setStartTime(LocalDateTime.now());
        request.setStopTime(LocalDateTime.now());
        // when
        repositoryInterface.save(request);
        // then
        verify(repositoryInterface).save(request);
    }
}