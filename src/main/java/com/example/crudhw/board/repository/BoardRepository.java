package com.example.crudhw.board.repository;

import com.example.crudhw.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    //Optional -> Null일수도 있어요
    // findById(id); -> id가 없어요 -> null을 리턴해
    // 있다고 희망을 가지고 board.get~~~(); -> NullPointerException이 터져버림..
    //

    Optional<Board> findByIdAndContent(Long id, String content);
}
