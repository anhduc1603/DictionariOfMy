package com.example.dictionariofmy.service;

import com.example.dictionariofmy.entity.reponse.DictionaryEntityResponse;
import com.example.dictionariofmy.entity.reponse.base.SuccessContent;

import java.io.IOException;

public interface GetDataFromOxfordService {
    SuccessContent<DictionaryEntityResponse> getData(String text) throws IOException;

    String testMessage();
}
