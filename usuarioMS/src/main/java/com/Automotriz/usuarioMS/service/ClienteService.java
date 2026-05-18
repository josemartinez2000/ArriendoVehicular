package com.Automotriz.usuarioMS.service;

import com.Automotriz.usuarioMS.model.Cliente;
import com.Automotriz.usuarioMS.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente buscarPorUsuario(Integer usuarioId) {
        return clienteRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Integer id, Cliente datos) {
        Cliente cliente = buscarPorId(id);
        cliente.setTipoCliente(datos.getTipoCliente());
        cliente.setDescripcion(datos.getDescripcion());
        return clienteRepository.save(cliente);
    }

    public void eliminar(Integer id) {
        if (!clienteRepository.existsById(id))
            throw new RuntimeException("Cliente no existe");
        clienteRepository.deleteById(id);
    }
}
