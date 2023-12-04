package com.memorize02.service;

import com.memorize02.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    BoardDTO findByBno(Long bno);
    List<BoardDTO> findAll();
    Long register(BoardDTO boardDTO);
}
