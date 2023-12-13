package com.msecurity04.controller;

import com.msecurity04.dto.BoardDTO;
import com.msecurity04.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/api/list")
    @ResponseBody
    public List<BoardDTO> findAll(){
        List<BoardDTO> dtoList = boardService.findAll();
        return dtoList;
    }

    @GetMapping("/api/read")
    @ResponseBody
    public BoardDTO findByBno(Long bno) {
        BoardDTO board = boardService.findByBno(bno);
        return board;
    }

    @PostMapping("/api/write")
    @ResponseBody
    public Long register(@Valid BoardDTO dto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
        }
        Long bno = boardService.register(dto);
        return bno;
    }

    @PostMapping("/api/modify")
    @ResponseBody
    public BoardDTO modify(@Valid BoardDTO dto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            String link = "bno=" + dto.getBno();
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("bno", dto.getBno());
            return dto;
        }
        boardService.modify(dto);
        redirectAttributes.addFlashAttribute("result", "수정완료");
        redirectAttributes.addAttribute("bno", dto.getBno());
        return dto;
    }

    @PostMapping("/api/remove")
    public String remove(Long bno, RedirectAttributes redirectAttributes){
        boardService.remove(bno);
        redirectAttributes.addFlashAttribute("result", "삭제 완료");
        return "redirect:/apiboard/list";
    }
}
