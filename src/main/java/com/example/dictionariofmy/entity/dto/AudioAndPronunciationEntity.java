package com.example.dictionariofmy.entity.dto;

import com.example.dictionariofmy.entity.reponse.Result;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AudioAndPronunciationEntity extends Result {
    private String audio;
    private String pronunciation;
}
