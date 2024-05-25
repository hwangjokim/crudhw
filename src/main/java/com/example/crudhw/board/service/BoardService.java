package com.example.crudhw.board.service;

import com.example.crudhw.board.domain.Board;
import com.example.crudhw.board.exception.BoardException;
import com.example.crudhw.board.repository.BoardRepository;
import com.example.crudhw.comment.domain.Comment;
import com.example.crudhw.comment.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public void createBoard(String title, String content) {
        Board board = Board.builder().title(title).content(content).build();
        boardRepository.save(board);
    }
    public Board getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new BoardException("Board not found"));
        // 그룹장 아닌데 그룹 삭제하는 API 호출했다?
        // Exception 던져서 "님 그룹장 ㄴㄴ"

        ArrayList<Comment> comments = board.getComments();
        return board;
    }
    public void deleteBoard(Long id) {
        Board board = getBoard(id);

        ArrayList<Comment> comments = commentRepository.findAllByBoard(board);
        for(Comment comment : comments) {
            commentRepository.delete(comment);
        }

        boardRepository.delete(board);
    }
    public void updateBoard(Long id, String title, String content) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new BoardException("그런 게시글 없어요"));
        board.updateBoard(title,content);
    }
    //참조 무결성 제약
    //게시글을 지우고싶다.
    // 근데 이 게시글에 댓글이 달렸어
    // 댓글 엔티티는, FK로 이 게시글을 참조하고 있지
    // 근데 Board를 지워버리면 얜 고아가 되는거지
    // 이 경우, 나중에 댓글만 조회하는데 고아 객체가 문제가 되니까
    // 지우려는 대상을, 다른곳에서 참조하면 지울수 없게 막아

    //댓글을 먼저 다지우면 돼. 그럼 참조하는 대상이 없어지니까
    //글을 지우고싶다? -> 해당 게시글을 참조하고 있는 댓글을 먼저 다 지운다 -> 게시글을 지운다


}
