package com.example.practice.board;

import com.example.practice.board.dto.BoardCreateDTO;
import com.example.practice.board.dto.BoardDTO;
import com.example.practice.board.dto.BoardUpdateDTO;
import com.example.practice.board.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardDTO create(BoardEntity boardEntity){
        BoardEntity _boardEntity = this.boardRepository.save(boardEntity);
        return _boardEntity.toDTO();
    }

    public BoardDTO update(BoardUpdateDTO boardUpdateDTO){
        System.out.println(boardUpdateDTO);
        BoardEntity boardEntity = boardUpdateDTO.toUpdateEntity();

        this.boardRepository.findById(boardEntity.getId()).orElseThrow(()-> new NullPointerException("없는 데이터") );
        System.out.println(boardEntity + "1");
        BoardEntity board = this.boardRepository.save(boardEntity);
        System.out.println(board + "2");
        return board.toDTO();
    }
}
