package com.example.prestamo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data

public class PrestamoRequest {
@NotBlank(message = "El responsable es obligatorio")
    private  String responsable;

@JsonFormat(pattern = "yyyy-MM-dd")
@NotNull(message = "La fecha es obligatoria")
private LocalDate fechaPrestamo;

@Min(value = 1, message = "La cantidad minima es 1")
    private int cantidad;

@NotNull(message = "El ID de la herramienta es olbigatoria")
    private Long herramientaId;
}

