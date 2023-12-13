package com.msecurity02.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/api/list")
    @ResponseBody
    public List<BoardDTO> findAll(){
        List<BoardDTO> list = boardService.findAll();
        return list;
    }

    @GetMapping("/api/read")
    @ResponseBody
    public BoardDTO findByBno(Long bno){
        BoardDTO dto = boardService.findByBno(bno);
        return dto;
    }

    @GetMapping("/api/register")
    @ResponseBody
    public Long register(BoardDTO dto){
        return boardService.register(dto);
    }
}
