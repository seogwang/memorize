package com.memorize03.service;

import com.memorize03.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    BoardDTO findByBno(Long bno);
    List<BoardDTO> findAll();
    Long register(BoardDTO boardDTO);
}
