package com.example.demo.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "제목은 필수 입력값")
    @Size(max=200,message = "최대 200글자")
    private String subject;

    @NotEmpty(message = "내용도 필수 입력값")
    private String content;
}
