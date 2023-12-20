package com.example.dictionariofmy.service.impl;

import com.example.dictionariofmy.entity.dto.AudioAndPronunciationEntity;
import com.example.dictionariofmy.entity.dto.ExampleSentencesEntity;
import com.example.dictionariofmy.entity.reponse.DictionaryEntityResponse;
import com.example.dictionariofmy.entity.reponse.ResponseService;
import com.example.dictionariofmy.entity.reponse.base.SuccessContent;
import com.example.dictionariofmy.service.GetDataFromLink;
import com.example.dictionariofmy.service.GetDataFromOxfordService;
import com.example.dictionariofmy.service.translate.TranslateService;
import com.example.dictionariofmy.util.Global_Constant;
import com.example.dictionariofmy.util.MessageUtility;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetDataFromOxfordServiceImpl implements GetDataFromOxfordService {
    private final TranslateService translateService;
    private final ResponseService responseService;
    private final GetDataFromLink getDataFromLink;
    private final MessageUtility messageUtility;
    @Override
    public SuccessContent<DictionaryEntityResponse> getData(String link) throws IOException {
        SuccessContent<DictionaryEntityResponse> responseSuccessContent = new SuccessContent<>();
        DictionaryEntityResponse responseDictionary = new DictionaryEntityResponse();
        Document document = getDataFromLink.getData( Global_Constant.LINK_OXFORD);
        try{
            Element audioUS = document.select("div.sound.audio_play_button.pron-us.icon-audio").first();
            List<AudioAndPronunciationEntity> listAudioAndPro = new ArrayList<>();

            if(audioUS != null){
                String mp3Source = audioUS.attr("data-src-mp3");
                String oggSource  = audioUS.attr("data-src-ogg");
                //Get pronunciation
                Elements pronunciation = document.select("div.top-container div.phons_br span.phon");
                String pronunciationUS = pronunciation.text();
                AudioAndPronunciationEntity audioUsEntity = new AudioAndPronunciationEntity(mp3Source,oggSource,pronunciationUS);
                listAudioAndPro.add(audioUsEntity);
            }

            Element audioUk = document.select("div.sound.audio_play_button.pron-uk.icon-audio").first();
            if(audioUk != null){
                String mp3Source = audioUk.attr("data-src-mp3");
                String oggSource  = audioUk.attr("data-src-ogg");
                //Get pronunciation
                Elements pronunciation = document.select("div.top-container div.phons_n_am span.phon");
                String pronunciationUk = pronunciation.text();
                AudioAndPronunciationEntity audioUKEntity = new AudioAndPronunciationEntity(mp3Source,oggSource,pronunciationUk);
                listAudioAndPro.add(audioUKEntity);
            }
            //Get pronunciation
//            Elements pronunciation = document.select("div.top-container span.phon");
//            if (pronunciation!=null){
//                for (Element item:pronunciation){
//                    System.out.println("pronunciation: " + item.text());
//                }
//            }

            //Từ loại
            Element fromCategory = document.select("div.top-container span.pos").first();
            if (fromCategory!=null){
                String category = fromCategory.text();
                System.out.println(category);
                responseDictionary.setTextCategory(category);
            }
            //Get images
            Element images = document.select("ol.senses_multiple a.topic").first();
            if (images!=null){
                String imageLink = images.attr("href");
                System.out.println(imageLink);
                responseDictionary.setImagesExample(imageLink);
            }

            List<ExampleSentencesEntity> listExampleSentencesEntities = new ArrayList<>();
            //Get y nghia
            Elements senseElements = document.select("ol.senses_multiple li.sense");
            // Loop through each sense element
            for (Element senseElement : senseElements) {
                ExampleSentencesEntity entity = new ExampleSentencesEntity();
                // Get the sense number
                String senseNumber = senseElement.attr("sensenum");

                // Get the definition text
                String definition = senseElement.select("span.def").text();

                // Print the extracted information
                System.out.println("Sense Number: " + senseNumber);
                System.out.println("Definition: " + definition);

                entity.setOrder(senseNumber);
                entity.setDefinition(definition);
                List<String> listExample = new ArrayList<>();
                Elements examples = senseElement.select("ul.examples span.x");
                for (Element item:examples){
                    String ex = item.text();
                    System.out.println(ex);
                    listExample.add(ex);
                }
                entity.setListExample(listExample);
                // You can extract other information as needed
                // Print a separator for better readability
                System.out.println("----------------------------");
                listExampleSentencesEntities.add(entity);

            }
            responseDictionary.setListExampleSentencesEntities(listExampleSentencesEntities);
            responseDictionary.setListAudioAndPro(listAudioAndPro);
            responseSuccessContent.setData(responseDictionary);
        }catch (Exception ex){

        }

        return responseSuccessContent;
    }

    @Override
    public String testMessage() {

        return messageUtility.getMessage("error.product.quantity", new Object[]{"hihihehe","meo meo"});
    }

}
