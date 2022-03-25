package com.example.demo.controller;

import com.example.demo.service.CriteriaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/criteria")
public class CriteriaController {
    private CriteriaService criteriaService;

    @GetMapping
    public void greteer(){
        criteriaService.Greeter();
    }
}
