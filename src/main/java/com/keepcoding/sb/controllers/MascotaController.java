package com.keepcoding.sb.controllers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.keepcoding.sb.entity.Mascota;
import com.keepcoding.sb.service.MascotaService;

@Controller

public class MascotaController {
	@Autowired
	private MascotaService mascotaService;
	
	@GetMapping("/mascota/{id}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable Long id) {
        Mascota mascota = mascotaService.mostrarMascotaById(id);
        if (mascota != null) {
            return ResponseEntity.ok(mascota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	@GetMapping("/buscar/{nombre}")
	public ResponseEntity<Mascota> buscarMascotaPorNombre(@PathVariable String nombre) {
	    Mascota mascota = mascotaService.mostrarMascotaNombre(nombre);
	    if (mascota != null) {
	        return ResponseEntity.ok(mascota);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	@GetMapping("/mascotas")
    public ResponseEntity<List<Mascota>> obtenerTodasLasMascotas() {
        List<Mascota> mascotas = mascotaService.mostrarMascota();
        if (mascotas.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.ok(mascotas); 
    }
	
	
	
	
	
	
	  @PostMapping("mascota")
	    public ResponseEntity<Mascota> saveMascota(@RequestBody Mascota mascota) {
	        Mascota savedMascota = mascotaService.saveMascota(mascota);
	        return ResponseEntity.ok(savedMascota);
	    }
	
	  @GetMapping("/mascotas/jovenes")
	  public ResponseEntity<List<Mascota>> obtenerMascotasMasJovenes() {
	      List<Mascota> mascotas = mascotaService.obtenerMascotasMasJovenes();
	      if (mascotas.isEmpty()) {
	          return ResponseEntity.noContent().build(); 
	      }
	      return ResponseEntity.ok(mascotas);
	  }
	  @GetMapping("/mascotas/pages")
	    public ResponseEntity<Page<Mascota>> obtenerMascotasPaginadas(
	            @RequestParam(value = "page", defaultValue = "0") int page,
	            @RequestParam(value = "size", defaultValue = "5") int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        Page<Mascota> mascotas = mascotaService.obtenerMascotasPaginadas(pageable);
	        if (mascotas.hasContent()) {
	            return ResponseEntity.ok(mascotas);
	        } else {
	            return ResponseEntity.noContent().build();
	        }
	    }
	  @GetMapping("/mascota/delete/{id}")
		public String deleteEmpleado(@PathVariable Long id) {
			mascotaService.eliminarMascota(id);
			return "redirect:/";
		}
}
