package br.gov.sp.fatec.Lab14sem2025.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.Lab14sem2025.entity.Trabalho;
import br.gov.sp.fatec.Lab14sem2025.service.TrabalhoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/trabalho")
public class TrabalhoController {
    
    @Autowired
    private TrabalhoService service;

    @GetMapping
    public ResponseEntity<List<Trabalho>> buscarTodos() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping(value = "/tituloNomeUsuario")
    public ResponseEntity<List<Trabalho>> buscarPorTituloENomeUsuario(
        @RequestParam("titulo") String titulo,
        @RequestParam("nomeUsuario") String nomeUsuario) {
        return ResponseEntity.ok().body(service.buscarPorTituloENomeUsuario(titulo, nomeUsuario));
    }

    @PostMapping
    public ResponseEntity<Trabalho> novoTrabalho(@RequestBody Trabalho trabalho) {
        trabalho = service.novoTrabalho(trabalho);
        return ResponseEntity
            .created(URI.create("/trabalho"))
            .body(trabalho);
    }
}
