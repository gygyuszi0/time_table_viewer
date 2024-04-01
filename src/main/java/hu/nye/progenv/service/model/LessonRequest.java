package hu.nye.progenv.service.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequest {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private String startTime;

    @NotNull
    private String stopTime;

    private String room;

}
