package com.Automotriz.sucursalMS.service;

import com.Automotriz.sucursalMS.model.Sucursal;
import com.Automotriz.sucursalMS.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> listar() { return sucursalRepository.findAll(); }
    public List<Sucursal> buscarPorComuna(String comuna) { return sucursalRepository.findByComuna(comuna); }

    public Sucursal buscarPorId(Integer id) {
        return sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
    }

    public Sucursal guardar(Sucursal sucursal) { return sucursalRepository.save(sucursal); }

    public Sucursal actualizar(Integer id, Sucursal datos) {
        Sucursal sucursal = buscarPorId(id);
        sucursal.setNombre(datos.getNombre());
        sucursal.setDireccion(datos.getDireccion());
        sucursal.setComuna(datos.getComuna());
        sucursal.setCantidadEmpleados(datos.getCantidadEmpleados());
        return sucursalRepository.save(sucursal);
    }

    public void eliminar(Integer id) {
        if (!sucursalRepository.existsById(id)) throw new RuntimeException("Sucursal no existe");
        sucursalRepository.deleteById(id);
    }
}
