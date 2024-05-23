package com.example.crudhw.board.service;

import com.example.crudhw.board.domain.Board;
import com.example.crudhw.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(String title, String content) {
        Board board = Board.builder().title(title).content(content).build();
        boardRepository.save(board);
    }
    public Board getBoard(Long id) {
        Board board = boardRepository.findById(id).get();
        return board;
    }
    public void deleteBoard(Long id) {
        Board board = getBoard(id);
        boardRepository.delete(board);
    }
    public void updateBoard(Long id, String title, String content) {
        Board board = boardRepository.findById(id).get();
        board.updateBoard(title,content);
    }
}
