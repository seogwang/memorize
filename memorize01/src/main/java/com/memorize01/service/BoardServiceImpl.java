package com.memorize01.service;

import com.memorize01.dto.BoardDTO;
import com.memorize01.entity.Board;
import com.memorize01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    public final BoardRepository boardRepository;
    public final ModelMapper modelMapper;

    @Override
    public BoardDTO findByBno(Long bno) {
        Optional<Board> result = boardRepository.findById(bno);
        BoardDTO dto = modelMapper.map(result, BoardDTO.class);
        return dto;
    }

    @Override
    public List<BoardDTO> findAll() {
        List<Board> list = boardRepository.findAll();
        List<BoardDTO> dtoList = list.stream().map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public Long register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        Long bno = boardRepository.save(board).getBno();
        return bno;
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        Optional<Board> result = boardRepository.findById(boardDTO.getBno());
        Board board = result.orElseThrow();
        board.change(boardDTO.getTitle(), boardDTO.getContent());
        boardRepository.save(board);
    }

    @Override
    public void remove(Long bno) {
        boardRepository.deleteById(bno);
    }
}
