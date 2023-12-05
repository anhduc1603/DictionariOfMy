package com.example.dictionariofmy.service.impl;

import com.example.dictionariofmy.service.GetDataFromOxfordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDataFromOxfordServiceImpl implements GetDataFromOxfordService {
    @Override
    public String getData() {
        return "Xin chào";
    }
}
