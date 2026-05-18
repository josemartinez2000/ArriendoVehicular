package com.Automotriz.usuarioMS.service;

import com.Automotriz.usuarioMS.model.Empleado;
import com.Automotriz.usuarioMS.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listar() {
        return empleadoRepository.findAll();
    }

    public Empleado buscarPorId(Integer id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    public Empleado buscarPorUsuario(Integer usuarioId) {
        return empleadoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    public List<Empleado> buscarPorSucursal(Integer sucursalId) {
        return empleadoRepository.findBySucursalId(sucursalId);
    }

    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado actualizar(Integer id, Empleado datos) {
        Empleado empleado = buscarPorId(id);
        empleado.setDescripcion(datos.getDescripcion());
        empleado.setSucursalId(datos.getSucursalId());
        empleado.setInfoBancaria(datos.getInfoBancaria());
        return empleadoRepository.save(empleado);
    }

    public void eliminar(Integer id) {
        if (!empleadoRepository.existsById(id))
            throw new RuntimeException("Empleado no existe");
        empleadoRepository.deleteById(id);
    }
}
