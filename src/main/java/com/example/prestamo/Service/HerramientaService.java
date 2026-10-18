package com.example.prestamo.Service;

import com.example.prestamo.Model.Herramienta;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface HerramientaService {
    List<Herramienta>listarHerramientas();
    Herramienta guardarHerramienta(Herramienta herramienta);
    Herramienta actualizarHerramienta(Long id, Herramienta herramienta);
    Herramienta buscarHerramienta(Long id);
    Void eliminarHerramienta( Long id);

}
