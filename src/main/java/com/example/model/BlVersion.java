package com.example.model;

import java.io.Serializable;

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


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "id", scope = BlVersion.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "bl_version", schema = "dbo")
public class BlVersion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6991399409625843325L;
	private Integer id;
	private Bl bl;
	private String jsonBl;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_bl_version")
	@SequenceGenerator(name = "sequence_bl_version", sequenceName = "seq_bl_version", allocationSize = 1, schema = "dbo", catalog = Entidades.CATALOGO_DB)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "bl_nro_bl", nullable = false)
	public Bl getBl() {
		return bl;
	}
	public void setBl(Bl bl) {
		this.bl = bl;
	}
	@Column(name = "json_bl")
	public String getJsonBl() {
		return jsonBl;
	}
	public void setJsonBl(String jsonBl) {
		this.jsonBl = jsonBl;
	}
	
	

}
