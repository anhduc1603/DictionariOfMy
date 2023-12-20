package com.example.dictionariofmy.service;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;


public interface GetDataFromLink {
    Document getData(String link) throws IOException;
}
