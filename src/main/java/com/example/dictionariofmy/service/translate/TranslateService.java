package com.example.dictionariofmy.service.translate;

import com.example.dictionariofmy.entity.reponse.ErrorCode;

import java.util.List;

public interface TranslateService {
    public String translate(String messageCode);
    public List<ErrorCode> translateWithErrorCodes(List<ErrorCode> errorCodes);
}
