package com.memorize01.controller;

import com.memorize01.dto.BoardDTO;
import com.memorize01.dto.PageRequestDTO;
import com.memorize01.dto.PageResponseDTO;
import com.memorize01.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
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

    @GetMapping("/board/list")
    public void listAll2(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);
    }

    @GetMapping({"/board/read", "/board/modify"})
    public void findByBno2(Long bno, PageRequestDTO pageRequestDTO, Model model) {
        BoardDTO boardDTO = boardService.findByBno(bno);
        log.info(boardDTO);
        model.addAttribute("dto", boardDTO);
    }

    @GetMapping("/board/write")
    public void boardForm2() {

    }

    @PostMapping("/board/write")
    public String boardWrite2(@Valid BoardDTO boardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("board POST register.........");

        if (bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/board/write";
        }
            log.info(boardDTO);

            Long bno = boardService.register(boardDTO);

            redirectAttributes.addFlashAttribute("result", bno);

            return "redirect:/board/list";
    }

    @PostMapping("/board/modify")
    public String modify(PageRequestDTO pageRequestDTO, @Valid BoardDTO boardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("board modify post......" + boardDTO);

        if(bindingResult.hasErrors()) {

            log.info("has errors......");

            String link = pageRequestDTO.getLink();
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("bno", boardDTO.getBno());

            return "redirect:/board/modify?"+link;
        }

        boardService.modify(boardDTO);
        redirectAttributes.addFlashAttribute("result", "modified");
        redirectAttributes.addAttribute("bno", boardDTO.getBno());

        return "redirect:/board/read";
    }

    @PostMapping("/board/remove")
    public String remove(Long bno, RedirectAttributes redirectAttributes){

        log.info("remove post.." + bno);
        boardService.remove(bno);
        redirectAttributes.addFlashAttribute("result", "removed");
        return "redirect:/board/list";
    }
}
