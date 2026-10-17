package com.example.prestamo.Repository;

import com.example.prestamo.Model.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {

}
