package com.example.prestamo.Controller;

import com.example.prestamo.Model.Herramienta;
import com.example.prestamo.Service.HerramientaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
@CrossOrigin(origins = "*")
public class HerramientaController {

    private final HerramientaService herramientaService;

    public HerramientaController(HerramientaService herramientaService) {
        this.herramientaService = herramientaService;
    }

    @GetMapping
    public List<Herramienta> consultarHerramientas() {
        return herramientaService.listarHerramientas();
    }

    @PostMapping
    public ResponseEntity<Herramienta> registrarHerramienta(@Valid @RequestBody Herramienta herramienta) {
        return ResponseEntity.ok(herramientaService.guardarHerramienta(herramienta));
    }
    @PutMapping
    public ResponseEntity<Herramienta> actualizarHerramienta(@PathVariable Long id, @Valid @RequestBody Herramienta herramienta){
        return ResponseEntity.ok(herramientaService.atualizarHerramienta(id, herramienta));
    }
}
