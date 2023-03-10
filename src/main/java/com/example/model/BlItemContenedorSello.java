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
 * BlItemContenedorSello generated by hbm2java
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "id", scope = BlItemContenedorSello.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "bl_item_contenedor_sello", schema = "dbo")
public class BlItemContenedorSello implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3615435963634463340L;
	private Integer id;
	private BlItemContenedor blItemContenedor = new BlItemContenedor();
	private String numero;
	private String codigo;
	private String emisor;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_contenedor_sello")
	@SequenceGenerator(name = "sequence_contenedor_sello", sequenceName = "seq_contenedor_sello", allocationSize = 1, schema = "dbo", catalog = Entidades.CATALOGO_DB)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bl_item_contenedor_id", nullable = false)
	public BlItemContenedor getBlItemContenedor() {
		return this.blItemContenedor;
	}

	public void setBlItemContenedor(BlItemContenedor blItemContenedor) {
		this.blItemContenedor = blItemContenedor;
	}

	@Column(name = "numero", nullable = false, length = 20)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "codigo", length = 10)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		if (codigo != null) {
			this.codigo = codigo.toUpperCase();
		} else {
			this.codigo = "";
		}
	}

	@Column(name = "emisor")
	public String getEmisor() {
		return this.emisor;
	}

	public void setEmisor(String emisor) {
		if (emisor != null) {
			this.emisor = emisor.toUpperCase();
		} else {
			this.emisor = "";
		}
	}

}
