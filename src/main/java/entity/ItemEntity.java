package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
//import org.springframework.context.annotation.Primary;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itmCode;

    private String item;
    private Integer qty;
    private Double price;
    private String catagory;
    private String description;

}

