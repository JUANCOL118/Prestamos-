package com.example.prestamo.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data

public class PrestamoRequest {
@NotBlank(message = "El responsable es obligatorio")
    private  String responsable;

@NotBlank(message = "La fecha es olbigatoria")
    private LocalDate fechaPrestamos;

@Min(value = 1, message = "La cantidad minima es 1")
    private int cantidad;

@NotBlank(message = "El ID de la herramienta es olbigatoria")
    private Long herramientaId;
}

