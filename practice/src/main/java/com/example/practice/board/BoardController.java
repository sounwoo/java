package com.example.practice.board;

import com.example.practice.board.dto.BoardCreateDTO;
import com.example.practice.board.dto.BoardDTO;
import com.example.practice.board.dto.BoardUpdateDTO;
import com.example.practice.board.entity.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor // DI(의존성 주입)의 방법 중에 생성자 자동 주입
@RequestMapping("/board")
@ResponseBody
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    public BoardDTO create(@RequestBody BoardCreateDTO boardCreateDTO){
        BoardEntity boardEntity = boardCreateDTO.toEntity();
        return this.boardService.create(boardEntity);
    }

    @PutMapping("/update")
    public BoardDTO update(@RequestBody BoardUpdateDTO boardUpdateDTO){
//        BoardEntity boardEntity = boardUpdateDTO.toUpdateEntity();
        return this.boardService.update(boardUpdateDTO);
    }
}
