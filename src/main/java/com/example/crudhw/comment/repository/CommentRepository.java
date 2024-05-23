package com.example.crudhw.comment.repository;

import com.example.crudhw.board.domain.Board;
import com.example.crudhw.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Optional<Comment> findByIdAndContent(Long id, String content);

    ArrayList<Comment> findAllByBoard(Board board);
}
