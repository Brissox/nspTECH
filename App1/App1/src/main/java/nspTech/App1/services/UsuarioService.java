package services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import nspTech.App1.model.Usuario;
import repository.UsuarioRepository;

@Service
@Transactional

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario BuscarUnUsuario(Long rut){
        return usuarioRepository.findById(rut).get();

    }
    public Usuario Guardar(Usuario usuario){
        return usuarioRepository.save(usuario);

    }

    public void Eliminar(long rut){
        usuarioRepository.deleteById(rut);
    }

}
