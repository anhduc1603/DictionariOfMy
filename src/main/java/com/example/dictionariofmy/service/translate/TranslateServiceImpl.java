package com.example.dictionariofmy.service.translate;

import com.example.dictionariofmy.entity.reponse.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TranslateServiceImpl implements TranslateService{
    private final MessageSource messageSource;
    @Override
    public String translate(String messageCode) {
        return this.messageSource.getMessage(messageCode, null, messageCode, null);
    }

    @Override
    public List<ErrorCode> translateWithErrorCodes(List<ErrorCode> errorCodes) {
        List<ErrorCode> list = new ArrayList<>();
        errorCodes.forEach(
                e ->list.add(new ErrorCode(e.getCode(),this.translate(e.getMessage())))
        );
        return list;
    }
}
