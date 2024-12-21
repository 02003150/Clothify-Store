package entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OderDetailsEntity {
    private Integer oderId;
    private String productName;
    private Double qty;
    private Double price;

}
