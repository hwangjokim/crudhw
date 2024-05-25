package com.example.crudhw.board.dto;

import com.example.crudhw.board.domain.Board;
import com.example.crudhw.common.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BoardResponse extends BaseResponse {
    private Board board;

    public BoardResponse(Boolean status, Board board) {
        super(status);
        this.board = board;
    }
}
