package com.example.dictionariofmy.exception;

import com.example.dictionariofmy.entity.reponse.ErrorCode;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CommandException extends RuntimeException {
    List<ErrorCode> errorCodes;

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, List<ErrorCode> errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }

}
