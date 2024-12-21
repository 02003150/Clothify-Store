package model;

import lombok.*;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    private Integer itmCode;
    private String item;
    private Integer qty;
    private Double price;
    private String catagory;
    private String description;
    private Double totalPrice;

    public Items(String item, Integer qty, Double price, String catagory, String description) {
        this.item = item;
        this.qty = qty;
        this.price = price;
        this.catagory = catagory;
        this.description = description;
        this.totalPrice=qty*price;

    }

    public Items(Integer code, String item, Integer qty, Double price, String catagory, String description) {
        this.itmCode=code;
        this.item = item;
        this.qty = qty;
        this.price = price;
        this.catagory = catagory;
        this.description = description;
        this.totalPrice=qty*price;
    }


//    public Items(String item, Integer qty, Double price, String catagory, String description) {
//        this.item = item;
//        this.qty = qty;
//        this.price = price;
//        this.catagory = catagory;
//        this.description = description;
//        this.totalPrice=qty*price;
//    }
}
