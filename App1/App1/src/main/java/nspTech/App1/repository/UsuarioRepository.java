package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nspTech.App1.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
