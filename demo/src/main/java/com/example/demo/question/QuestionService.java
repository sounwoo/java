package com.example.demo.question;

import com.example.demo.DataNotFoundException;
import com.example.demo.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQeustion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            System.out.println(question.get().hashCode());
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }

    }

    public void create(String subject, String content, SiteUser siteUser) {
        Question question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setAuthor(siteUser);
        question.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }
}
