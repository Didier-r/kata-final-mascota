package com.keepcoding.sb.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity

public class Mascota {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private Date  fechaNac;
	private String raza;
	private float peso;
	private boolean has_chip;
	private String url_foto;

}
