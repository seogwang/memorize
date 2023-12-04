package com.memorize04.service;

import com.memorize04.dto.BoardDTO;
import com.memorize04.entity.Board;
import com.memorize04.repository.BoardRepository;
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
        List<BoardDTO> DTOList = list.stream().map( board ->
                modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());
        return DTOList;
    }

    @Override
    public BoardDTO findByBno(Long bno) {
        Optional<Board> board = boardRepository.findById(bno);
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

    @Override
    public Long register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        Long bno = boardRepository.save(board).getBno();
        return bno;
    }
}
