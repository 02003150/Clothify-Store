package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OderDetails {
    private Integer oderId;
    private String productName;
    private Double qty;
    private Double price;
}
