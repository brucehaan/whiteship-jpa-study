package me.whiteship.demospringdata;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public void addStudy(Study study) {
        this.getStudies().add(study); // Optional, but 객체지향을 위해선 해야 함
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }
}
