package com.memorize02.service;

import com.memorize02.dto.BoardDTO;
import com.memorize02.entity.Board;
import com.memorize02.repository.BoardRepository;
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
    public BoardDTO findByBno(Long bno) {
        Optional<Board> result = boardRepository.findById(bno);
        BoardDTO dto = modelMapper.map(result, BoardDTO.class);
        return dto;
    }

    @Override
    public List<BoardDTO> findAll() {
        List<Board> list = boardRepository.findAll();
        List<BoardDTO> DTOList = list.stream().map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());
        return DTOList;
    }

    @Override
    public Long register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        Long bno = boardRepository.save(board).getBno();
        return bno;
    }
}
