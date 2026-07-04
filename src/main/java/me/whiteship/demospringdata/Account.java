package me.whiteship.demospringdata;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "home_street")
            )
    })
    private Address address;
}
