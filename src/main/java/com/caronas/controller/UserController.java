package com.caronas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caronas.repository.UserRepository;

@RestController
@RequestMapping("/data")
public class UserController {

  @Autowired
  private UserRepository query;

  @GetMapping("/users")
  public ResponseEntity list() {
    var resultado = this.query.findAll();

    if (resultado.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
    }

    return ResponseEntity.status(HttpStatus.FOUND).body(resultado);

  }

  

}
