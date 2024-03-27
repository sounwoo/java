package com.example.practice.board.dto;

import lombok.*;

import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDTO {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private int view;
    private String createAt;
    private String updateAt;
}
