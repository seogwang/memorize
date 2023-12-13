package com.msecurity02.repository;

import com.msecurity02.board.Board;
import com.msecurity02.board.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void InsertTest() {
        IntStream.rangeClosed(1,100).forEach( i -> {
            Board board = Board.builder()
                    .title("title.... " + i)
                    .content("content.... " + i)
                    .writer("user" + (i % 10))
                    .build();
            Board result = boardRepository.save(board);
            log.info("BNO : " + result.getBno());
        });
    }
}
