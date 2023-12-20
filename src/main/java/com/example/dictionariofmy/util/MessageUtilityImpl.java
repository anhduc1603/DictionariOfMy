package com.example.dictionariofmy.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageUtilityImpl implements MessageUtility{

    private final MessageSource messageSource;


    public  String getMessage(String mes,Object[] args) {
        return this.messageSource.getMessage(mes,args, LocaleContextHolder.getLocale());
    }
}
