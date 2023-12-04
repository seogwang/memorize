package com.memorize05.service;

import com.memorize05.dto.BoardDTO;
import com.memorize05.entity.Board;
import com.memorize05.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
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
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

    @Override
    public Long register(BoardDTO dto) {
        Board board = modelMapper.map(dto, Board.class);
        Long bno = boardRepository.save(board).getBno();
        return bno;
    }
}
