package com.keepcoding.sb.serviceImpl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.keepcoding.sb.entity.Mascota;
import com.keepcoding.sb.repository.MascotaRepository;
import com.keepcoding.sb.service.MascotaService;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class MascotaServiceImpl implements MascotaService {
	@Autowired
	private MascotaRepository mascotaRepository;
	
	 @Override
	    public Mascota saveMascota(Mascota mascota) {
	        return mascotaRepository.save(mascota);
	    }
	 @Override
	 public Mascota mostrarMascotaById(Long id) {
		 return mascotaRepository.findById(id).get();
	 }
	 @Override
	    public Mascota mostrarMascotaNombre(String nombre) {
	        return mascotaRepository.findByNombre(nombre).orElse(null);
	    }
	 @Override
	 public List<Mascota> mostrarMascota(){
		 return mascotaRepository.findAll();
	 }

	 @Override
	 public List<Mascota> obtenerMascotasMasJovenes() {
	     return mascotaRepository.findAll(Sort.by(Sort.Direction.DESC, "fechaNac")).stream()
	             .limit(20)
	             .collect(Collectors.toList());
	 }
	 @Override
	    public Page<Mascota> obtenerMascotasPaginadas(Pageable pageable) {
	        return mascotaRepository.findAll(pageable);
	    }
	 @Override
		public void eliminarMascota(Long id) {
			mascotaRepository.deleteById(id);
		}
}
