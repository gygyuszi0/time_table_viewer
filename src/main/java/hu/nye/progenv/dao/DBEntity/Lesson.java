package hu.nye.progenv.dao.DBEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @NotNull
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime stopTime;

    private String room;

}
