package me.whiteship.demospringdata;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Post {
    @Id @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "post", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private Set<Comment> comments = new HashSet<>();

    public void addComment(Comment comment) {
        this.getComments().add(comment);
        comment.setPost(this);
    }
}
