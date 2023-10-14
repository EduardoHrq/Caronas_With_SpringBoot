package com.caronas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caronas.repository.UserRepository;

@Controller
@RequestMapping("/")
public class Controle {

  @Autowired
  private UserRepository query;

  @RequestMapping
  public String home(Model model) {

    var resultado = this.query.findAll();

    System.out.println(resultado);
    if (resultado == null) {
      System.out.println("não tem");
    }

    model.addAttribute("model", resultado);

    return "index";
  }

  @PostMapping("/data/increments/{type}/{id}")
  public String update(@PathVariable("type") String tipo, @PathVariable("id") int id) {

    var resultado = this.query.findById(id);

    if (resultado == null) {
      System.out.println("NOT FOUND");
    } else if (tipo.equals("meia")) {
      System.out.println(resultado);
      resultado.setMeia(resultado.getMeia() + 1);
      System.out.println(resultado);

    } else if (tipo.equals("inteira")) {
      System.out.println(resultado);
      resultado.setInteira(resultado.getInteira() + 1);
      System.out.println(resultado);

    }

    var saved = this.query.save(resultado);

    return "redirect:/";

  }

  @PostMapping("/data/pay/{id}")
  public String paying(@PathVariable("id") int id) {

    var resultado = this.query.findById(id);

    if (resultado == null) {
      System.out.println("NOT FOUND");
    }

    resultado.setInteira(0);
    resultado.setMeia(0);

    var saved = this.query.save(resultado);

    return "redirect:/";

  }

}
