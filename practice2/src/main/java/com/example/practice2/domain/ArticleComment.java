package com.example.practice2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Entity
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createAt"),
        @Index(columnList = "createBy")
})

public class ArticleComment extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private  Article article; // 게시글

    @Setter
    @Column(nullable = false, length = 500)
    private String content; // 본문

    protected ArticleComment() {}

    private ArticleComment(Article article, String content){
        this.article = article;
        this.content = content;
    }

    public static ArticleComment of(Article article, String content){
        return  new ArticleComment(article, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleComment that = (ArticleComment) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
