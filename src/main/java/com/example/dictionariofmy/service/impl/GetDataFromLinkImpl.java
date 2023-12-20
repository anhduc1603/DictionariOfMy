package com.example.dictionariofmy.service.impl;

import com.example.dictionariofmy.service.GetDataFromLink;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
@RequiredArgsConstructor
public class GetDataFromLinkImpl implements GetDataFromLink {
    @Override
    public Document getData(String link) throws IOException {

        return Jsoup.connect(link).get();
    }
}
