package com.Automotriz.usuarioMS.service;

import com.Automotriz.usuarioMS.model.Usuario;
import com.Automotriz.usuarioMS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> listarClientes() {
        return usuarioRepository.findByTipo(1);
    }

    public List<Usuario> listarEmpleados() {
        return usuarioRepository.findByTipo(2);
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario buscarPorRut(String rut) {
        return usuarioRepository.findByRut(rut)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Integer id, Usuario datos) {
        Usuario usuario = buscarPorId(id);
        usuario.setRut(datos.getRut());
        usuario.setNombre(datos.getNombre());
        usuario.setCorreo(datos.getCorreo());
        usuario.setTelefono(datos.getTelefono());
        usuario.setDireccion(datos.getDireccion());
        usuario.setTipo(datos.getTipo());
        usuario.setClaveUnica(datos.getClaveUnica());
        return usuarioRepository.save(usuario);
    }

    public void eliminar(Integer id) {
        if (!usuarioRepository.existsById(id))
            throw new RuntimeException("Usuario no existe");
        usuarioRepository.deleteById(id);
    }
}
