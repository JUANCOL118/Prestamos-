package com.example.prestamo.Service.Impl;

import com.example.prestamo.Service.PrestamoService;
import com.example.prestamo.DTO.PrestamoRequest;
import com.example.prestamo.Model.Herramienta;
import com.example.prestamo.Model.Prestamo;
import com.example.prestamo.Repository.HerramientaRepository;
import com.example.prestamo.Repository.PrestamoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final HerramientaRepository herramientaRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository, HerramientaRepository herramientaRepository) {
        this.prestamoRepository = prestamoRepository;
        this.herramientaRepository = herramientaRepository;
    }

    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public List<Prestamo> listarPorHerramienta(Long herramientaId) {
        return prestamoRepository.findByHerramientaId(herramientaId);
    }

    @Override
    @Transactional
    public Prestamo registrarPrestamo(PrestamoRequest request) {
        Herramienta herramienta = herramientaRepository.findById(request.getHerramientaId())
                .orElseThrow(() -> new RuntimeException("La herramienta no existe"));

        if (request.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad a prestar debe ser mayor a cero.");
        }

        if (request.getCantidad() > herramienta.getCantidad()) {
            throw new IllegalArgumentException("Cantidad solicitada superior a las unidades disponibles.");
        }

        // Descontar unidades y actualizar inventario en una misma transacción[cite: 2]
        herramienta.setCantidad(herramienta.getCantidad() - request.getCantidad());
        herramientaRepository.save(herramienta);

        Prestamo prestamo = new Prestamo();
        prestamo.setResponsable(request.getResponsable());
        prestamo.setFechaPrestamo(request.getFechaPrestamos());
        prestamo.setCantidad(request.getCantidad());
        prestamo.setHerramienta(herramienta);

        return prestamoRepository.save(prestamo);
    }
}
