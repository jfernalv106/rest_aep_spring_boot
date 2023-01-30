package com.example.model;

import com.example.config.Entidades;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "id", scope = DireccionClte.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "direccion_clte", schema = "dbo")
public class DireccionClte {
	
	
	private Integer id;
	private Cliente cliente;
	private String direccion;
	private String descripcion;
	private boolean dirDefault;
	private String comuna;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_direccion_clte")
	@SequenceGenerator(name = "sequence_direccion_clte", sequenceName = "seq_direccion_clte", allocationSize = 1, schema = "dbo", catalog = Entidades.CATALOGO_DB)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "rut", nullable = false)
	public Cliente getCliente() {
		return cliente;
	}
	@Column(name = "direccion")
	public String getDireccion() {
		return direccion;
	}
	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	@Column(name = "dir_Default")
	public boolean isDirDefault() {
		return dirDefault;
	}
	@Column(name = "comuna")
	public String getComuna() {
		return comuna;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDirDefault(boolean dirDefault) {
		this.dirDefault = dirDefault;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

}
