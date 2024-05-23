package com.example.crudhw.comment.domain;

import com.example.crudhw.board.domain.Board;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String nickname;

    //Comment : Board = N : 1

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id") // 실제 디비에는 Board 객체가 아니라, board_id가 FK로 들어간다
    //실제 db에 반영. Comment 테이블에 board_id가 생겨
    private Board board;

    @Builder
    public Comment(String content, String nickname, Board board) {
        this.content = content;
        this.nickname = nickname;
        this.board = board;
    }

    public void updateComment(String content) {
        this.content = content;
    }
}
