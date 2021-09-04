package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {
    
    @RequestMapping("/alo")
    String teste(){
        System.out.println("-----------------> teste");
        return "atividade4";
    }
}
