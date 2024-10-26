package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employers {
    private Integer id;
    private String name;
    private String company;
    private String employerEmail;

    public Employers(String name, String company, String employerEmail) {

        this.name = name;
        this.company = company;
        this.employerEmail = employerEmail;
    }
}
