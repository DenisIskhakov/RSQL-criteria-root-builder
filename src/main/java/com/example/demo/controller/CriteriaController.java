package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.CriteriaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/criteria")
public class CriteriaController {
    private CriteriaService criteriaService;

    @GetMapping
    public void greteer(){
        criteriaService.Greeter();
    }
    @GetMapping("/{firstName}")
    public List<Person> findByName(@PathVariable String firstName){
       return criteriaService.findFirstName(firstName);
    }
    @GetMapping("/like/{s}")
    public List<Person> findByLike(@PathVariable String s){
        return criteriaService.findByLike(s);
    }
}
