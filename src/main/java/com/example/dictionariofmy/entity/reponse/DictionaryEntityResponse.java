package com.example.dictionariofmy.entity.reponse;

import com.example.dictionariofmy.entity.dto.AudioAndPronunciationEntity;
import com.example.dictionariofmy.entity.dto.ExampleSentencesEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DictionaryEntityResponse  {
    private List<AudioAndPronunciationEntity> listAudioAndPro;
    private String textCategory; //Từ loại
    private String imagesExample; //Ảnh ví dụ nếu có
    private List<ExampleSentencesEntity> listExampleSentencesEntities;
}
