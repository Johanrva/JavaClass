package com.testgradle.testgradle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class activity2 {
@RequestMapping
    public String message(){
        return "¡Hola soy Johan Romero y este es mi primer proyecto web con Spring y JAVA";
    }
}
