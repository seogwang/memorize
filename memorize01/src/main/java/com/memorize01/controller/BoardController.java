package com.memorize01.controller;

import com.memorize01.dto.BoardDTO;
import com.memorize01.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    public final BoardService boardService;

    @GetMapping("/api/list")
    @ResponseBody
    public List<BoardDTO> listAll() {
        List<BoardDTO> boardDTOList = boardService.findAll();
        return boardDTOList;
    }

    @GetMapping("/api/read")
    @ResponseBody
    public BoardDTO findByBno(Long bno) {
        BoardDTO boardDTO = boardService.findByBno(bno);
        return boardDTO;
    }

    @GetMapping("/api/write")
    public String boardForm() {
        return "board/write";
    }

    @PostMapping("/api/write")
    @ResponseBody
    public Long boardWrite(@Valid BoardDTO boardDTO) {
        return boardService.register(boardDTO);
    }
}
