package com.Automotriz.reservasMS.service;

import com.Automotriz.reservasMS.client.SucursalClient;
import com.Automotriz.reservasMS.client.UsuarioClient;
import com.Automotriz.reservasMS.client.VehiculoClient;
import com.Automotriz.reservasMS.dto.*;
import com.Automotriz.reservasMS.model.Reserva;
import com.Automotriz.reservasMS.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private VehiculoClient vehiculoClient;

    @Autowired
    private SucursalClient sucursalClient;

    public List<Reserva> listar() { return reservaRepository.findAll(); }

    public Reserva buscarPorId(Integer id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    public List<Reserva> buscarPorCliente(String rutCliente) {
        return reservaRepository.findByRutCliente(rutCliente);
    }

    public List<Reserva> buscarPorEstado(String estado) {
        return reservaRepository.findByEstado(estado);
    }

    public Reserva guardar(Reserva reserva) {
        reserva.setEstado("PENDIENTE");
        return reservaRepository.save(reserva);
    }

    public Reserva actualizar(Integer id, Reserva datos) {
        Reserva reserva = buscarPorId(id);
        reserva.setRutCliente(datos.getRutCliente());
        reserva.setPatente(datos.getPatente());
        reserva.setSucursalId(datos.getSucursalId());
        reserva.setFechaInicio(datos.getFechaInicio());
        reserva.setFechaFin(datos.getFechaFin());
        reserva.setEstado(datos.getEstado());
        return reservaRepository.save(reserva);
    }

    public void eliminar(Integer id) {
        if (!reservaRepository.existsById(id)) throw new RuntimeException("Reserva no existe");
        reservaRepository.deleteById(id);
    }

    // Endpoint estrella: llama a los 3 MS via Feign
    public ReservaDetalleDTO obtenerDetalle(Integer id) {
        Reserva reserva = buscarPorId(id);
        UsuarioDTO usuario = usuarioClient.obtenerUsuarioPorRut(reserva.getRutCliente());
        VehiculoDTO vehiculo = vehiculoClient.obtenerVehiculoPorPatente(reserva.getPatente());
        SucursalDTO sucursal = sucursalClient.obtenerSucursal(reserva.getSucursalId());
        return new ReservaDetalleDTO(reserva.getId(), reserva.getEstado(),
                reserva.getFechaInicio(), reserva.getFechaFin(), usuario, vehiculo, sucursal);
    }
}
