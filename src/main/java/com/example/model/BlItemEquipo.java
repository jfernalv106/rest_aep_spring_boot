package com.example.model;

import com.example.config.Entidades;
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

// Generated 11-05-2018 17:31:26 by Hibernate Tools 5.2.10.Final



/**
 * BlItemEquipo generated by hbm2java
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "id", scope = BlItemEquipo.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "bl_item_equipo", schema = "dbo")
public class BlItemEquipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5600524424453781932L;
	private Integer id;
	private BlItem blItem;
	private Character tipoEquipo;
	private String sigla;
	private String identificacion;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_item_equipo")
	@SequenceGenerator(name = "sequence_item_equipo", sequenceName = "seq_item_equipo", allocationSize = 1, schema = "dbo", catalog = Entidades.CATALOGO_DB)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "bl_item_id", nullable = false)
	public BlItem getBlItem() {
		return this.blItem;
	}

	public void setBlItem(BlItem blItem) {
		this.blItem = blItem;
	}

	@Column(name = "tipo_equipo", nullable = false, length = 1)
	public Character getTipoEquipo() {
		return this.tipoEquipo;
	}

	public void setTipoEquipo(Character tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

	@Column(name = "sigla", nullable = false, length = 10)
	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Column(name = "identificacion", nullable = false, length = 10)
	public String getIdentificacion() {
		if(identificacion!=null) {
		return this.identificacion.toUpperCase();	
		}else {
			return this.identificacion;
		}
		
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

}
