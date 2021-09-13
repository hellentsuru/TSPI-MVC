package br.edu.iftm.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controler {
    
    @RequestMapping("/")
    String metodo(){
        return "layout";
    }

    // @GetMapping("/static/img")
    @RequestMapping("/pag2")
    String metodo2(){
        return "pag2";
    }
}
