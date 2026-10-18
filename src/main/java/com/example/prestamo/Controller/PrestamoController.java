package com.example.prestamo.Controller;

import com.example.prestamo.DTO.PrestamoRequest;
import com.example.prestamo.Model.Prestamo;
import com.example.prestamo.Service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "*")
public class PrestamoController {

    private final PrestamoService prestamoService;

    // Inyección por constructor sin @Autowired
    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    public List<Prestamo> consultarPrestamos() {
        return prestamoService.listarPrestamos();
    }

    @GetMapping("/herramienta/{id}")
    public List<Prestamo> consultarPorHerramienta(@PathVariable Long id) {
        return prestamoService.listarPorHerramienta(id);
    }

    @PostMapping
    public ResponseEntity<?> registrarPrestamo(@Valid @RequestBody PrestamoRequest request) {
        try {
            Prestamo prestamo = prestamoService.registrarPrestamo(request);
            return ResponseEntity.ok(prestamo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public Prestamo consultarPorId(@PathVariable Long id) {
        return prestamoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable Long id, @Valid @RequestBody PrestamoRequest request) {
        Prestamo prestamo = prestamoService.actualizarPrestamo(id, request);
        return ResponseEntity.ok(prestamo);
    }

    @DeleteMapping("/{id}")
    public void eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarPrestamo(id);
    }
}
