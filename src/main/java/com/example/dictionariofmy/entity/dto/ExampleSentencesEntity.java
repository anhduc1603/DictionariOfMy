package com.example.dictionariofmy.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExampleSentencesEntity {
    private String order;
    private String definition;
    private List<String> listExample;
}
