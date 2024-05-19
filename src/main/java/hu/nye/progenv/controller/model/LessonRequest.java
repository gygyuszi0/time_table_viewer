package hu.nye.progenv.controller.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.nye.progenv.controller.model.Constants.YYYY_MM_DD_HH_MM;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Request model for Lesson.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequest {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @JsonFormat(pattern = YYYY_MM_DD_HH_MM)
    private LocalDateTime startTime;

    @NotNull
    @JsonFormat(pattern = YYYY_MM_DD_HH_MM)
    private LocalDateTime stopTime;

    private String room;

}
