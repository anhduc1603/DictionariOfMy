package com.example.dictionariofmy.controller;

import com.example.dictionariofmy.entity.reponse.ResponseService;
import com.example.dictionariofmy.service.GetDataFromOxfordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class AdminController extends BaseController<GetDataFromOxfordService>{

    public AdminController(GetDataFromOxfordService service, ResponseService responseService) {
        super(service, responseService);
    }
    @GetMapping("/all")
    ResponseEntity<?> saveNewProduct() {
        return super.success(getService().getData());
    }
}

