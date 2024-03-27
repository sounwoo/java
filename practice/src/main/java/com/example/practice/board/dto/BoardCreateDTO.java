package com.example.practice.board.dto;

import com.example.practice.board.entity.BoardEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardCreateDTO {
    private String writer;
    private String title;
    private String content;
    private int view;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .writer(writer)
                .title(title)
                .content(content)
                .view(0)
                .build();
    }
}
