package com.example.dictionariofmy.util;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;



public interface MessageUtility {
    String getMessage(String mes,Object[] args);
}
