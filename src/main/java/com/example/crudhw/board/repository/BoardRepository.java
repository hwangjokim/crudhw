package com.example.crudhw.board.repository;

import com.example.crudhw.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    Optional<Board> findByIdAndContent(Long id, String content);
}
