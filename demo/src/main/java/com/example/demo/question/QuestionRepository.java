package com.example.demo.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // findBy+엔티티속성명 명시하게되면 입력한 엔티티 속성의 값으로 조회가능
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
    List<Question> findBySubjectLike(String subject);
//    And	findBySubjectAndContent(String subject, String content)	Subject, Content 열과 일치하는 데이터를 조회
//    Or	findBySubjectOrContent(String subject, String content)	Subject열 또는 Content 열과 일치하는 데이터를 조회
//    Between	findByCreateDateBetween(LocalDateTime fromDate, LocalDateTime toDate)	CreateDate 열의 데이터 중 정해진 범위 내에 있는 데이터를 조회
//    LessThan	findByIdLessThan(Integer id)	Id 열에서 조건보다 작은 데이터를 조회
//    GreaterThanEqual	findByIdGreaterThanEqual(Integer id)	Id 열에서 조건보다 크거나 같은 데이터를 조회
//    Like	findBySubjectLike(String subject)	Subject 열에서 문자열 ‘subject’와 같은 문자열을 포함한 데이터를 조회
//    In	findBySubjectIn(String[] subjects)	Subject 열의 데이터가 주어진 배열에 포함되는 데이터만 조회
//    OrderBy	findBySubjectOrderByCreateDateAsc(String subject)	Subject 열 중 조건에 일치하는 데이터를 조회하여 CreateDate 열을 오름차순으로 정렬하여 반환
}
