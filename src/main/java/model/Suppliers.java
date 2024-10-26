package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Suppliers {
    private Integer id;
    private String name;
    private String company;
    private String email;
    private String item;

    public Suppliers(String name, String company, String email, String item) {

        this.name = name;
        this.company = company;
        this.email = email;
        this.item = item;
    }
}
