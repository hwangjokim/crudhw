package com.example.crudhw.board.domain;

import com.example.crudhw.comment.domain.Comment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@NoArgsConstructor
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String nickname;

    //board : comment = 1 : N
    // 즉, FK를 가진건 comment다
    // board를 조회할때, comment도 같이 가져오고싶으면?

    //1쪽에서, 조회를 위한 역 매핑을 지원

    @OneToMany(mappedBy = "board")
    //Db에 영향이 없어. 정말 딱 조회 편의를 위한 기능이야
    // 그래서 이 배열에 연산(쓰기, 지우기 등등..)을 해도 무의미해.

    private ArrayList<Comment> comments = new ArrayList<>();


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
