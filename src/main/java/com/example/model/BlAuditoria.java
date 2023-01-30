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
 * BlAuditoria generated by hbm2java
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "id", scope = BlAuditoria.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "bl_auditoria", schema = "dbo")
public class BlAuditoria implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7549301902508207746L;
	private Integer id;
	private Bl bl;
	private String descripcion;


	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_auditoria")
	@SequenceGenerator(name = "sequence_auditoria", sequenceName = "dbo.seq_auditoria", allocationSize = 1, schema = "dbo", catalog = Entidades.CATALOGO_DB)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "bl_nro_bl", nullable = false)
	public Bl getBl() {
		return this.bl;
	}

	public void setBl(Bl bl) {
		this.bl = bl;
	}

	@Column(name = "descripcion", length = 4000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
