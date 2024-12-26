package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

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
    private LocalDate date;


    public AddToCart(Integer oderId, String item, Double totalPrice, LocalDate date) {
        this.oderId=oderId;
        this.item=item;
        this.totalPrice=totalPrice;
        this.date=date;
    }
}
