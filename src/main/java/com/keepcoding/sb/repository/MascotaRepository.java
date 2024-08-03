package com.keepcoding.sb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.keepcoding.sb.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
	Optional<Mascota> findByNombre(String nombre);
	
	Page<Mascota> findAll(Pageable pageable);
	
}
