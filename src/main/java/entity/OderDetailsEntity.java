package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class OderDetailsEntity {
    @Id
    private Integer oderId;

    private Double netTotal;
    private LocalDate date;
}
