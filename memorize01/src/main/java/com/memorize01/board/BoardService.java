package com.memorize01.board;

import com.memorize01.board.page.PageRequestDTO;
import com.memorize01.board.page.PageResponseDTO;

import java.util.List;

public interface BoardService {
    BoardDTO findByBno(Long bno);
    List<BoardDTO> findAll();
    Long register(BoardDTO boardDTO);
    void modify(BoardDTO boardDTO);
    void remove(Long bno);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
