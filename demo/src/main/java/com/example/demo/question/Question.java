package com.example.demo.question;

import com.example.demo.answer.Answer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // EAGER 객체를 조회할때 미리 answerList를 가져옴
    // Lazy answerList를 조회하면 그떄 가져온다
    // 설정 안할시 question.getAnswerList를 조회시 에러(DB세션이 종료되어 가져오지 못함)
    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
