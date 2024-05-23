package com.example.crudhw.comment.service;

import com.example.crudhw.board.domain.Board;
import com.example.crudhw.board.repository.BoardRepository;
import com.example.crudhw.board.service.BoardService;
import com.example.crudhw.comment.domain.Comment;
import com.example.crudhw.comment.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public void createComment (String content, String nickname, Long boardId) {
        Board board =  boardRepository.findById(boardId).get();
        Comment comment = Comment.builder().content(content).nickname(nickname).board(board).build();
        commentRepository.save(comment);
    }

    public Comment viewComment (Long id) {
        Comment comment = commentRepository.findById(id).get();
        return comment;
    }

    public void updateComment(Long id, String content, String nickname) {
        Comment comment = commentRepository.findById(id).get();
        comment.updateComment(content);
    }

    public void deleteComment (Long id) {
        Comment comment = commentRepository.findById(id).get();
        commentRepository.delete(comment);
    }
}
