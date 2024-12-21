package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AddToCart {
    private Integer oderId;
    private String customerName;
    private Integer itemCode;
    private String item;
    private Double unitPrice;
    private Integer qty;
    private String description;
    private Double totalPrice;
}
