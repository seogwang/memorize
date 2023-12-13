package com.msecurity04.service;

import com.msecurity04.dto.BoardDTO;
import com.msecurity04.entity.Board;

import java.util.List;

public interface BoardService {
    List<BoardDTO> findAll();
    BoardDTO findByBno(Long bno);
    Long register(BoardDTO dto);
    void modify(BoardDTO dto);
    void remove(Long bno);
}
