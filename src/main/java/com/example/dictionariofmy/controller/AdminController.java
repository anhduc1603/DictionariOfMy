package com.example.dictionariofmy.controller;

import com.example.dictionariofmy.entity.reponse.DictionaryEntityResponse;
import com.example.dictionariofmy.entity.reponse.ResponseService;
import com.example.dictionariofmy.entity.reponse.base.SuccessContent;
import com.example.dictionariofmy.service.GetDataFromOxfordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("")
public class AdminController extends BaseController<GetDataFromOxfordService>{

    public AdminController(GetDataFromOxfordService service, ResponseService responseService) {
        super(service, responseService);
    }
    @GetMapping("/all")
    SuccessContent<DictionaryEntityResponse> saveNewProduct(@RequestParam("text")String text) throws IOException {
        return getService().getData(text);
    }

    @GetMapping("/getMessage")
    ResponseEntity<?> getMessage(){
        return super.success(getService().testMessage());
    }
}

