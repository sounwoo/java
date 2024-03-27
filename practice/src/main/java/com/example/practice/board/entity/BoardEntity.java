package com.example.practice.board.entity;

import com.example.practice.board.dto.BoardCreateDTO;
import com.example.practice.board.dto.BoardDTO;
import com.example.practice.board.dto.BoardUpdateDTO;
import com.example.practice.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString
@Table(name = "board_table")
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String writer;

    @Column(length = 20)
    private String title;

    @Column(length =500)
    private String content;

    @Column
    private int view;

    public BoardDTO toDTO(){
        return BoardDTO.builder()
                .id(getId())
                .writer(getWriter())
                .title(getTitle())
                .content(getContent())
                .view(getView())
                .createAt(getCreateAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .updateAt(getUpdateAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }
}
