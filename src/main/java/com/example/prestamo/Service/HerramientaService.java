package com.example.prestamo.Service;

import com.example.prestamo.Model.Herramienta;

import java.util.List;

public interface HerramientaService {
    List<Herramienta>listarHerramientas();
    Herramienta guardarHerramienta(Herramienta herramienta);
}
