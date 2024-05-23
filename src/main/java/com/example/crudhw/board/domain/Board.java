package com.example.crudhw.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String nickname;

    @Builder
    public Board(String title, String content, String nickname) {
        this.title = title;
        this.content = content;
        this.nickname = nickname;
    }

    public void updateBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
