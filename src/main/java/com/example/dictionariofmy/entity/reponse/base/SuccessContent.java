package com.example.dictionariofmy.entity.reponse.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessContent<T> {
    private String message;
    private T data;
}
