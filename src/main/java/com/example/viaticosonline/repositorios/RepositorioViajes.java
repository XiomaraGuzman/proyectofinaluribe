package com.example.viaticosonline.repositorios;

import com.example.viaticosonline.entidades.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioViajes extends JpaRepository<Viaje, Integer> {
}
