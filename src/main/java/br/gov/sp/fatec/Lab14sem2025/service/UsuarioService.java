package br.gov.sp.fatec.Lab14sem2025.service;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.gov.sp.fatec.Lab14sem2025.entity.Usuario;
import br.gov.sp.fatec.Lab14sem2025.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepo;
    
    public Usuario buscarPorId(Long id) {

        Optional<br.gov.sp.fatec.Lab14sem2025.entity.Usuario> usuarioOp = usuarioRepo.findById(id);
        if (usuarioOp.isPresent()) {
            return usuarioOp.get();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id invalido!");
    }

    public Usuario novoUsuario (br.gov.sp.fatec.Lab14sem2025.entity.Usuario usuario) {
        
        if(usuario == null||
        usuario.getNome() == null ||
        usuario.getSenha() == null ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome e senha  invalidos");
        }
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepo.findAll ();
    }

}