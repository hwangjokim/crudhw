package com.example.crudhw.common.exception;


import com.example.crudhw.board.exception.BoardException;
import com.example.crudhw.common.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // RestController는 리턴이 JSON, Controller -> HTML
public class CustomExceptionHandler {

    @ExceptionHandler(BoardException.class)
    public ExceptionResponse boardExceptionHandler(BoardException e) {
        return new ExceptionResponse(false,  e.getMessage());
    }

}

/*
{
    "success" : false,
    "message" : "없는 게시글 어쩌구",
 }
 */


// 프론트엔드 입장에서 생각
// GET : 조회
// POST: 생성
// PUT,PATCH : 수정
// DELETE : 삭제

