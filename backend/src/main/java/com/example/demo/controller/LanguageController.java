package com.example.demo.controller;                     //กำลังบอกว่า package นี้ เป็นของ Controller
import com.example.demo.entity.*;                         //import entity ทุกอันมาไว้ในนี้
import com.example.demo.repository.*;                     //import repo ทุกอันมาไว้ในนี้
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController                                 
@CrossOrigin(origins = "http://localhost:8080") 
class LanguageController{                         
    @Autowired                                          
    private LanguageRepository languageRepository;     

    public LanguageController(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @GetMapping("/language")                           
    public Collection<Language> Languages(){                  
        return languageRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/language/{id}")
    public Optional<Language> Languages(@PathVariable Long id) {
        Optional<Language> language = languageRepository.findById(id);
        return language;
    }
}