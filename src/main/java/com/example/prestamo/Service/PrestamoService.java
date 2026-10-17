package com.example.prestamo.Service;

import com.example.prestamo.DTO.PrestamoRequest;
import com.example.prestamo.Model.Prestamo;
import java.util.List;

public interface PrestamoService {
    List<Prestamo> listarPrestamos();
    List<Prestamo> listarPorHerramienta(Long herramientaId);
    Prestamo registrarPrestamo(PrestamoRequest request);
}