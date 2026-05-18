package com.Automotriz.usuarioMS.config;

import com.Automotriz.usuarioMS.model.*;
import com.Automotriz.usuarioMS.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDataBase(
            UsuarioRepository usuarioRepo,
            ClienteRepository clienteRepo,
            EmpleadoRepository empleadoRepo,
            AntecedentesRepository antecedentesRepo) {

        return args -> {
            if (usuarioRepo.count() > 0) {
                System.out.println("No se cargó nada porque ya habían datos");
            } else {
                // Usuarios
                Usuario u1 = new Usuario(null, "8114567-9", "Mariano Elizalde",
                        "mariano@gmail.com", "+56912345678", "Av. Siempre Viva 123", 1, "clave123");
                Usuario u2 = new Usuario(null, "9234567-8", "Ana González",
                        "ana@gmail.com", "+56987654321", "Calle Principal 456", 1, "clave456");
                Usuario u3 = new Usuario(null, "15234567-8", "Carlos Rodríguez",
                        "carlos@motornya.cl", "+56911111111", "Av. Central 789", 2, "empleado123");

                usuarioRepo.save(u1);
                usuarioRepo.save(u2);
                usuarioRepo.save(u3);

                // Clientes
                Cliente c1 = new Cliente(null, "NATURAL", "Cliente particular", u1);
                Cliente c2 = new Cliente(null, "EMPRESA", "Empresa de transportes", u2);

                clienteRepo.save(c1);
                clienteRepo.save(c2);

                // Empleado
                Empleado e1 = new Empleado(null, "Vendedor sucursal centro", 1, "Banco Estado / 123456789", u3);
                empleadoRepo.save(e1);

                // Antecedentes
                Antecedentes a1 = new Antecedentes(null, "VIGENTE", 0, c1);
                Antecedentes a2 = new Antecedentes(null, "VIGENTE", 1, c2);

                antecedentesRepo.save(a1);
                antecedentesRepo.save(a2);

                System.out.println("✅ Datos de prueba cargados en usuarioMS");
            }
        };
    }
}