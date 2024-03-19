package hu.nye.progenv.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequest {

    private String name;
    private Long startTime;
    private Long stopTime;
    private String room;

}
