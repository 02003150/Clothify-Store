package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OderDetails {
    private Integer oderId;
    private Double netTotal;
    private LocalDate date;



    //    }
//        this.date=date;
//        this.price=totalPrice;
//        this.productName=productName;
//        this.oderId=oderId;
//    public OderDetails(Integer oderId, String productName, Double totalPrice, LocalDate date) {
//    private String productName;
// private Double qty;
}
