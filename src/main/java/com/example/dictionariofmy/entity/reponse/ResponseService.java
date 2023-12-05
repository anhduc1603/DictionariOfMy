package com.example.dictionariofmy.entity.reponse;

import com.example.dictionariofmy.exception.CommandException;

public interface ResponseService {
    <T> Response<T> success(T data);

    <T> Response<T> success(String message, T data);

    <T> Response<T> success();

    <T> Response<T> success(String message);

    <T> Response<T> error(CommandException exception);

    <T> Response<T> errorWithErrorCode(CommandException exception);

}
