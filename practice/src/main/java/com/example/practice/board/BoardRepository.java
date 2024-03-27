package com.example.practice.board;

import com.example.practice.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Jpa(데이터 type, Pk type)
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
