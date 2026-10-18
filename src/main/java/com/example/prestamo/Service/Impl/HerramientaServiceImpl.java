package com.example.prestamo.Service.Impl;

import com.example.prestamo.Model.Herramienta;
import com.example.prestamo.Repository.HerramientaRepository;
import com.example.prestamo.Service.HerramientaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerramientaServiceImpl implements HerramientaService {

    private final HerramientaRepository herramientaRepository;

    public HerramientaServiceImpl(HerramientaRepository herramientaRepository) {
        this.herramientaRepository = herramientaRepository;
    }

    @Override
    public List<Herramienta> listarHerramientas() {
        return herramientaRepository.findAll();
    }

    @Override
    public Herramienta guardarHerramienta(Herramienta herramienta) {
        if (herramienta.getCantidad()<0){
            throw new IllegalArgumentException("no se permiten cantidades negativas");

        }
        return herramientaRepository.save(herramienta);
    }

    @Override
    public Herramienta actualizarHerramienta(Long id, Herramienta herramienta) {
        Herramienta existente = buscarHerramienta(id);
        existente.setNombre(herramienta.getNombre());
        existente.setCantidad(herramienta.getCantidad());
        return herramientaRepository.save(existente);
    }

    @Override
    public Herramienta buscarHerramienta(Long id) {
        return herramientaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Herramienta no encontrada"));
    }

    @Override
    public Void eliminarHerramienta(Long id) {
        Herramienta existente = buscarHerramienta(id);
        herramientaRepository.delete(existente);
        return null;
    }

}
