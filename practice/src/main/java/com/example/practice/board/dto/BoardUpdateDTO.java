package com.example.practice.board.dto;

import com.example.practice.board.entity.BoardEntity;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardUpdateDTO {
    private Long id;
    private String writer;
    private String title;
    private String content;

    public BoardEntity toUpdateEntity(){
        return BoardEntity.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
    }
}
