package kr.sfox.alpha.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post extends BaseEntity {

    private String title;
    @Lob
    private String content;
    private String author;
}
