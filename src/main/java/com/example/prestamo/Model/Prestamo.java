package com.example.prestamo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prestamo")

public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message =  "el responsable es obligatorio")
    private String responsable;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "la fecha del prestamo es obligatoria")
    private LocalDate fechaPrestamo;

    @Min(value = 1, message = "La cantidad minima es 1")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name ="herramienta_id", nullable = false)
    private Herramienta herramienta;

    @JsonProperty("herramientaId")
    public Long getHerramientaId() {
        return (this.herramienta != null) ? this.herramienta.getId() : 0L;
    }
}
