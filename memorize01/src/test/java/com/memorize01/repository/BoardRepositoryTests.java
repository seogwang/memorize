package com.memorize01.repository;

import com.memorize01.board.BoardRepository;
import com.memorize01.board.BoardDTO;
import com.memorize01.board.page.PageRequestDTO;
import com.memorize01.board.page.PageResponseDTO;
import com.memorize01.entity.Board;
import com.memorize01.board.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @Test
    public void testInsert() {
        IntStream.range(1,100).forEach(i -> {
            Board board = Board.builder()
                .title("title..."+i)
                .content("content..."+i)
                .writer("user" + (i % 10))
                .build();

            Board result = boardRepository.save(board);
            log.info("BNO: " + result.getBno());
        });
    }

    @Test
    public void testSearch1() {
        Pageable pageable = PageRequest.of(1, 10, Sort.by("bno").descending());
        boardRepository.search1(pageable);
    }

    @Test
    public void testSearch2(){
        String[] types = {"t", "c", "w"};
        String keyword = "1";
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);

        log.info(result.getTotalPages());
        log.info(result.getSize());
        log.info(result.getNumber());
        log.info(result.hasPrevious() + ": " + result.hasNext());
        result.getContent().forEach(board -> log.info(board));
    }

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);

        log.info(responseDTO);
    }

}
