package com.example.crudhw.comment.controller;

import com.example.crudhw.comment.domain.Comment;
import com.example.crudhw.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/api/comment")
    public Boolean createComment(@RequestParam String content, @RequestParam String nickname, @RequestParam Long boardId) {
        commentService.createComment(content, nickname, boardId);
        return true;
    }

    //댓글 조회
    @GetMapping("/api/comment")
    public Comment viewComment(@RequestParam Long id) {
        Comment comment = commentService.viewComment(id);
        return comment;
    }

    //댓글 수정
    @PutMapping("/api/comment")
    public Boolean updateComment(@RequestParam Long id, @RequestParam String content, @RequestParam String nickname) {
        commentService.updateComment(id, content, nickname);
        return true;
    }

    //댓글 삭제
    @DeleteMapping("/api/comment")
    public Boolean deleteComment(@RequestParam Long id) {
        commentService.deleteComment(id);
        return true;
    }
}
