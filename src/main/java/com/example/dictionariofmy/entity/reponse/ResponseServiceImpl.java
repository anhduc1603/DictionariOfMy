package com.example.dictionariofmy.entity.reponse;

import com.example.dictionariofmy.entity.reponse.base.ErrorContent;
import com.example.dictionariofmy.entity.reponse.base.SuccessContent;
import com.example.dictionariofmy.exception.CommandException;
import com.example.dictionariofmy.service.translate.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService{
    private final TranslateService translateService;

    @Override
    public <T> Response<T> success(T data) {
        SuccessContent<T> content = new SuccessContent<>(this.translateService.translate("success.default"),"0", data);
        return new Response(content, HttpStatus.OK);
    }

    @Override
    public <T> Response<T> success(String messageCode, T data) {
        SuccessContent<T> content = new SuccessContent<>(this.translateService.translate(messageCode),"0",data);
        return new Response(content, HttpStatus.OK);
    }

    @Override
    public <T> Response<T> success() {
        SuccessContent<T> content = new SuccessContent<>();
        content.setMessage(this.translateService.translate("success.default"));
        return new Response(content, HttpStatus.OK);
    }

    @Override
    public <T> Response<T> success(String messageCode) {
        SuccessContent<T> content = new SuccessContent<>();
        content.setMessage(this.translateService.translate(messageCode));
        return new Response(content, HttpStatus.OK);
    }

    @Override
    public <T> Response<T> error(CommandException exception) {
        ErrorContent content = new ErrorContent();
        List<ErrorCode> errorCodes = this.translateService.translateWithErrorCodes(
                exception.getErrorCodes());
        content.setMessage(this.translateService.translate(exception.getMessage()));
        content.setErrorCodes(errorCodes);
        return new Response(content, HttpStatus.OK);
    }

    @Override
    public <T> Response<T> errorWithErrorCode(CommandException exception) {
        ErrorContent content = new ErrorContent();
        content.setErrorCodes(exception.getErrorCodes());
        content.setMessage(this.translateService.translate(exception.getMessage()));
        return new Response(content, HttpStatus.OK);
    }
}
