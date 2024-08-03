package com.keepcoding.sb.service;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


import org.springframework.stereotype.Service;

import com.keepcoding.sb.entity.Mascota;



@Service
public interface MascotaService {
	
	Mascota saveMascota(Mascota mascota);
	
	public Mascota mostrarMascotaById(Long id);
	
	Mascota mostrarMascotaNombre(String nombre);
	
	public List<Mascota> mostrarMascota();
	
	List<Mascota> obtenerMascotasMasJovenes();

	Page<Mascota> obtenerMascotasPaginadas(Pageable pageable);
	
	public void eliminarMascota(Long id);
}
