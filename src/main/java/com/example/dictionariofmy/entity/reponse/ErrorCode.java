package com.example.dictionariofmy.entity.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorCode implements Serializable {

    private int code;
    private String message;
}
