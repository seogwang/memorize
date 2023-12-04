package com.memorize04.service;

import com.memorize04.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> findAll();
    BoardDTO findByBno(Long bno);
    Long register(BoardDTO boardDTO);
}
