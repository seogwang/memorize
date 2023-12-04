package com.memorize05.service;

import com.memorize05.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> findAll();
    BoardDTO findByBno(Long bno);
    Long register(BoardDTO dto);
}
