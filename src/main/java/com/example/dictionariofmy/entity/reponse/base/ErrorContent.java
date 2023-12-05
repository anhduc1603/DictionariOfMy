package com.example.dictionariofmy.entity.reponse.base;

import com.example.dictionariofmy.entity.reponse.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorContent {
    private String message;
    private List<ErrorCode> errorCodes;
}
