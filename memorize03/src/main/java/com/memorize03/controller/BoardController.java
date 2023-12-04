package com.memorize03.controller;

import com.memorize03.dto.BoardDTO;
import com.memorize03.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("list")
    @ResponseBody
    public List<BoardDTO> findAll(){
        List<BoardDTO> dtoList = boardService.findAll();
        return dtoList;
    }

    @GetMapping("read")
    @ResponseBody
    public BoardDTO findByBno(Long bno){
        BoardDTO boardDTO = boardService.findByBno(bno);
        return boardDTO;
    }

    @GetMapping("write")
    public String writeForm(){
        return "/board/writeForm";
    }

    @PostMapping
    @ResponseBody
    public Long register(@Valid BoardDTO boardDTO) {
        return boardService.register(boardDTO);
    }
}
