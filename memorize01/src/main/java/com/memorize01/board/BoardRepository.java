package com.memorize01.board;

import com.memorize01.entity.Board;
import com.memorize01.board.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
    @Query(value = "select now()", nativeQuery = true)
    String getTime();
}
