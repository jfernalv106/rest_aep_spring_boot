package com.example.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "cod", scope = BlItemTipoBulto.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "bl_item_tipo_bulto", schema = "dbo")
public class BlItemTipoBulto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -506432018402602523L;
	private String cod;
	private String tipoBulto;



	@Id
	@Column(name = "cod", unique = true, nullable = false)
	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	@Column(name = "nombre", nullable = false, length = 10)
	public String getTipoBulto() {
		return tipoBulto;
	}

	public void setTipoBulto(String tipoBulto) {
		this.tipoBulto = tipoBulto;
	}
	@Transient
	public String getBulto() {
		return "(" + cod + ") " + tipoBulto;
	}

}
