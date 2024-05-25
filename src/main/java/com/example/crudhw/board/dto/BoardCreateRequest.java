package com.example.crudhw.board.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardCreateRequest {
    public String title;
    public String content;
    public String nickname;
}
