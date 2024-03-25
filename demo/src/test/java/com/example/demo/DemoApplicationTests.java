package com.example.demo;

import com.example.demo.answer.Answer;
import com.example.demo.answer.AnswerRepository;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;
    @Test
    void testJpa() {
        // Create
        /*Question q1 = new Question();
        q1.setSubject("제목");
        q1.setContent("내용");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);*/

        // Read
        /*List<Question> all = this.questionRepository.findAll();
        assertEquals(1, all.size());

        Question q= all.get(0);
        assertEquals("제목",q.getSubject());*/

        /*Optional<Question> oq = this.questionRepository.findById(1);
        if(oq.isPresent()) {
            Question q = oq.get();
            assertEquals("제목", q.getSubject());
        }*/

       /* Question q = this.questionRepository.findBySubject("제목");
        assertEquals(1,q.getId());*/

        /*Question q = this.questionRepository.findBySubjectAndContent("제목","내용");
        assertEquals(1, q.getId());*/

        /*sbb%	'sbb'로 시작하는 문자열
        %sbb	'sbb'로 끝나는 문자열
        %sbb%	'sbb'를 포함하는 문자열
        List<Question> qList = this.questionRepository.findBySubjectLike("제%");
        Question q = qList.get(0);
        assertEquals("제목",q.getSubject());*/

        // Update
        /*Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);*/

        // Delete
        /*assertEquals(1, this.questionRepository.count());
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(0,this.questionRepository.count());*/

        // join
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("답변 내용");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);

    }

}
