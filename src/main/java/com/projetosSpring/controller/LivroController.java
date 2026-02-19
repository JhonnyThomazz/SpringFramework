package com.projetosSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosSpring.entity.Livro;
import com.projetosSpring.service.LivroService;

@RestController
@RequestMapping ("/livro")
public class LivroController {
	
	//Link
	@Autowired
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    
    //Function_GetById
    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
        Livro livro = livroService.getLivroById(id);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Function_GetAll
    @GetMapping("/")
    public ResponseEntity<List<Livro>> getAllLivros() {
        List<Livro> produtos = livroService.getAllLivros();
        return ResponseEntity.ok(produtos);
    }

    //Function_Save
    @PostMapping("/")
    public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livros) {
        Livro saveLivros = livroService.salvarLivro(livros);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveLivros);
    }
    
    //Function_Alter
    @PutMapping("/{id}")
    public ResponseEntity<Livro> alteraProdutos(@PathVariable Long id, @RequestBody Livro livro) {
        Livro atualizaLivro = livroService.atualizarLivro(id, livro);
        if (atualizaLivro != null) {
            return ResponseEntity.ok(atualizaLivro); //Error204_NoContent
        } else {
            return ResponseEntity.notFound().build(); //Error404_ItemNotFound
        }
    }
    
    //Function_Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Livro> excluirLivro(@PathVariable Long id) {
        boolean apagaLivro = livroService.excluirLivro(id);
        if (apagaLivro) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //Error204_NoContent
        } else {
            return ResponseEntity.notFound().build(); //Error404_ItemNotFound
        }
    }
}	

