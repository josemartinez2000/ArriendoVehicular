package com.Automotriz.usuarioMS.service;

import com.Automotriz.usuarioMS.model.Antecedentes;
import com.Automotriz.usuarioMS.repository.AntecedentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AntecedentesService {

    @Autowired
    private AntecedentesRepository antecedentesRepository;

    public List<Antecedentes> listar() {
        return antecedentesRepository.findAll();
    }

    public Antecedentes buscarPorId(Integer id) {
        return antecedentesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Antecedentes no encontrados"));
    }

    public Antecedentes buscarPorCliente(Integer clienteId) {
        return antecedentesRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new RuntimeException("Antecedentes no encontrados"));
    }

    public Antecedentes guardar(Antecedentes antecedentes) {
        return antecedentesRepository.save(antecedentes);
    }

    public Antecedentes actualizar(Integer id, Antecedentes datos) {
        Antecedentes antecedentes = buscarPorId(id);
        antecedentes.setEstadoLicencia(datos.getEstadoLicencia());
        antecedentes.setRegistroMultas(datos.getRegistroMultas());
        return antecedentesRepository.save(antecedentes);
    }

    public void eliminar(Integer id) {
        if (!antecedentesRepository.existsById(id))
            throw new RuntimeException("Antecedentes no existen");
        antecedentesRepository.deleteById(id);
    }
}
