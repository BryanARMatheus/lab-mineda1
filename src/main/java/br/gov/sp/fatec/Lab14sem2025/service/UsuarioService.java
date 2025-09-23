package br.gov.sp.fatec.Lab14sem2025.service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.Lab14sem2025.entity.Autorizacao;
import br.gov.sp.fatec.Lab14sem2025.entity.Usuario;
import br.gov.sp.fatec.Lab14sem2025.repository.AutorizacaoRepository;
import br.gov.sp.fatec.Lab14sem2025.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private AutorizacaoRepository autRepo;

    public UsuarioService(UsuarioRepository usuarioRepo, AutorizacaoRepository autRepo) {
        this.usuarioRepo = usuarioRepo;
        this.autRepo = autRepo;
    }

    public Usuario buscarPorId(Long id) {

        Optional<br.gov.sp.fatec.Lab14sem2025.entity.Usuario> usuarioOp = usuarioRepo.findById(id);
        if (usuarioOp.isPresent()) {
            return usuarioOp.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id invalido!");
    }

    @Override
    @Transactional
    public Usuario novoUsuario (br.gov.sp.fatec.Lab14sem2025.entity.Usuario usuario) {
        
               if(usuario == null ||
                usuario.getNome() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Faltam informações!");
        }
        usuario.setId(null);
        Set<Autorizacao> autorizacoes = new HashSet<Autorizacao>();
        for(Autorizacao aut: usuario.getAutorizacoes()) {
            autorizacoes.add(buscarAutorizacaoPorId(aut.getId()));
        }
        usuario.setAutorizacoes(autorizacoes);
        return usuarioRepo.save(usuario);
    }

    private Autorizacao buscarAutorizacaoPorId(Long id) {
        if(id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "codigo de autorizacao nulo!"); 
        }
        return autRepo.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Autorização não existe!");
        });
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepo.findAll ();
    }

}