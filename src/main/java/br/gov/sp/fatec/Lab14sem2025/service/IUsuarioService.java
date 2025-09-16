package br.gov.sp.fatec.Lab14sem2025.service;
import java.util.List;
import br.gov.sp.fatec.Lab14sem2025.entity.Usuario;


public interface IUsuarioService {

    public Usuario buscarPorId(Long id);

    public Usuario novoUsuario(Usuario usuario);
    
    public List<Usuario> buscarTodos();
}