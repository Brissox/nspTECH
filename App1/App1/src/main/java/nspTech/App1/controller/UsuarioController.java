package nspTech.App1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nspTech.App1.model.Usuario;
import services.UsuarioService;

@RestController
@RequestMapping
@postMapping

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioservice;

    @GetMapping
    public ResponseEntity<List<Usuario>> Listar() {
        List<Usuario> usuarios = usuarioservice.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.ok(usuarios);
        }

    }

    @GetMapping("/{rut}")
    public ResponseEntity<Usuario> BuscarUnUsuario(@PathVariable Long rut) {
        try {
            Usuario usuario = usuarioservice.BuscarUnUsuario(rut);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @postMapping
    public ResponseEntity<Usuario> Guardar(@RequestBody Usuario usuario) {
        Usuario usuarioNuevo = usuarioservice.Guardar(usuario);
        return ResponseEntity.status(HttpStatus.body(usuarioNuevo));
    }
    @deleteMapping
    public ResponseEntity<?> eliminar(@PathVariable Long rut) {
        try{
            usuarioservice.Eliminar(rut);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{rut}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long rut, @RequestBody Usuario usuario){
        try {
            Usuario usuarioEditar = usuarioservice.BuscarUnUsuario(rut);
            usuarioEditar.setRut(rut);
            usuarioEditar.setNombre(usuario.getNombre());
            usuarioEditar.setMail(usuario.getMail());
            usuarioEditar.setIdcurso(usuario.getIdcurso());

            usuarioservice.save(usuarioEditar);

            return ResponseEntity.ok(usuarioservice);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }

}



}
