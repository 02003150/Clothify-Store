package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private String address;
    private String nic;
    private String number;

    public User(String name, String address, String nic, String number) {
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.number = number;
    }
}
