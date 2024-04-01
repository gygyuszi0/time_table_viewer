package hu.nye.progenv.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static hu.nye.progenv.service.model.Constants.YYYY_MM_DD_HH_MM;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequest {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @JsonFormat(pattern = YYYY_MM_DD_HH_MM )
    private LocalDateTime startTime;

    @NotNull
    @JsonFormat(pattern = YYYY_MM_DD_HH_MM )
    private LocalDateTime stopTime;

    private String room;

}
