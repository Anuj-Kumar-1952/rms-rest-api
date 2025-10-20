package io.github.anujkumar.recruitment_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rms")
public class HomeController {
   @GetMapping("/home")
   public String getMethodName() {
       return new String("hello! welcome to the rms");
   }
   
}
