package com.memorize01.service;

import com.memorize01.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    BoardDTO findByBno(Long bno);
    List<BoardDTO> findAll();
    Long register(BoardDTO boardDTO);
    void modify(BoardDTO boardDTO);
    void remove(Long bno);
}
