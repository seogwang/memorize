package com.memorize05.controller;

import com.memorize05.dto.BoardDTO;
import com.memorize05.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("list")
    @ResponseBody
    public List<BoardDTO> list() {
        List<BoardDTO> dtoList = boardService.findAll();
        return dtoList;
    }

    @GetMapping("read")
    @ResponseBody
    public BoardDTO read(Long bno) {
        BoardDTO dto = boardService.findByBno(bno);
        return dto;
    }

    @GetMapping("write")
    public String writeForm(){
        return "board/writeForm";
    }

    @PostMapping("write")
    @ResponseBody
    public Long write(@Valid BoardDTO dto){
        return boardService.register(dto);
    }
}
