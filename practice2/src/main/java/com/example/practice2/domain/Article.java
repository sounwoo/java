package com.example.practice2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Entity
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createAt"),
        @Index(columnList = "createBy")
})
//@EntityListeners(AuditingEntityListener.class)
public class Article extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String title; // 제목

    @Setter
    @Column(nullable = false, length = 10000)
    private String content; // 본문

    @Setter
    private String hashtag; // 해시태그

    //    @CreatedDate
    //    @Column(nullable = false)
    //    private LocalDateTime createAt; // 생성일시
    //
    //    @CreatedBy
    //    @Column(nullable = false, length = 100)
    //    private String createBy; // 생성자
    //
    //    @LastModifiedDate
    //    @Column(nullable = false)
    //    private LocalDateTime modifiedAt; // 수정일시
    //
    //    @LastModifiedBy
    //    @Column(nullable = false, length = 100)
    //    private String modifiedBy; // 수정자

    // @Embedded -> 공통 필드를 class 작성 -> 필드를 AA aa
    // @MappedSuperclass 사용 할수 있음

    @ToString.Exclude // 순한참조 방지
    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    protected Article(){}
    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

