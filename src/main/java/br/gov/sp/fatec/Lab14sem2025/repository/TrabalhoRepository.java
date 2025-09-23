package br.gov.sp.fatec.Lab14sem2025.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.Lab14sem2025.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    List<Trabalho> findByTituloContainingAndUsuarioNomeContaining(String titulo, String nome);
    
    
    @Query("select t from Trabalho t join t.usuario u where t.titulo like %?1% and u.nome like %?2%")
    public List<Trabalho> buscarPorTituloENomeUsuario(String titulo, String nomeUsuario);

}   
