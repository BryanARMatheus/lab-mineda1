package br.gov.sp.fatec.Lab14sem2025.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.Lab14sem2025.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}