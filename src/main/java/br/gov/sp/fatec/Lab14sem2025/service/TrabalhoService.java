package br.gov.sp.fatec.Lab14sem2025.service;

import java.util.List;

import br.gov.sp.fatec.Lab14sem2025.entity.Trabalho;

public interface TrabalhoService {

    public List<Trabalho> buscarTodos();
    
    public Trabalho novoTrabalho(Trabalho trabalho);
    
    public List<Trabalho> buscarPorTituloENomeUsuario(String titulo, String nomeUsuario);
    
}
