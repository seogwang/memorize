package com.msecurity04.service;

import com.msecurity04.dto.BoardDTO;
import com.msecurity04.entity.Board;
import com.msecurity04.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<BoardDTO> findAll() {
        List<Board> list = boardRepository.findAll();
        List<BoardDTO> dtoList = list.stream().map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public BoardDTO findByBno(Long bno) {
        Optional<Board> board = boardRepository.findById(bno);
        BoardDTO dto = modelMapper.map(board, BoardDTO.class);
        return dto;
    }

    @Override
    public Long register(BoardDTO dto) {
        Board board = modelMapper.map(dto, Board.class);
        Long bno = boardRepository.save(board).getBno();
        return bno;
    }

    @Override
    public void modify(BoardDTO dto) {
        Optional<Board> result = boardRepository.findById(dto.getBno());
        Board board = result.orElseThrow();
        board.change(dto.getTitle(), dto.getContent());
        boardRepository.save(board);
    }

    @Override
    public void remove(Long bno) {
        boardRepository.deleteById(bno);
    }
}
