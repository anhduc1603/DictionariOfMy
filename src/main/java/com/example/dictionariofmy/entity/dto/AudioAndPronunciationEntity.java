package com.example.dictionariofmy.entity.dto;

import com.example.dictionariofmy.entity.reponse.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AudioAndPronunciationEntity extends Result {
    private String audio;
    private String audiOgg;
    private String pronunciation;
}
