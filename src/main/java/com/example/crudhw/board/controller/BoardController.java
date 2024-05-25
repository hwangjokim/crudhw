package com.example.crudhw.board.controller;

import com.example.crudhw.board.domain.Board;
import com.example.crudhw.board.dto.BoardCreateRequest;
import com.example.crudhw.board.dto.BoardResponse;
import com.example.crudhw.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    //게시글 작성
    @PostMapping("/api/board")
    public Boolean createBoard(@RequestBody BoardCreateRequest request) {
        boardService.createBoard(request.title, request.content);
        return true;
    }

    //게시글 조회
    @GetMapping("/api/board")
    public ResponseEntity<BoardResponse> getBoard(@RequestParam Long id) {
        Board board = boardService.getBoard(id);
        BoardResponse response = new BoardResponse(true, board);
        //HTTP statusCode 200 OK, 400 Bad Request, 404 Not found
        return ResponseEntity.ok(response);
    }

    //게시글 수정
    @PutMapping ("/api/board")
    public Boolean updateBoard(@RequestParam Long id, @RequestParam String title, @RequestParam String content) {
        boardService.updateBoard(id, title, content);
        return true;
    }

    //게시글 삭제
    @DeleteMapping("/api/board")
    public Boolean deleteBoard(@RequestParam Long id) {
        boardService.deleteBoard(id);
        return true;
    }
}
