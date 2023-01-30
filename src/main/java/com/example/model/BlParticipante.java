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
 * BlParticipante generated by hbm2java
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "id", scope = BlParticipante.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "bl_participante", schema = "dbo")
public class BlParticipante implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4771714240607047532L;
	private Integer id;
	private Bl bl;
	private String tipoParticipante;
	private String tipoId;
	private String nacionId;
	private String valorId;
	private String nombres;
	private String codigoPais;
	private String codigoAlmacen;
	private String direccion;
	private String comuna;
	private String telefono;
	private String email;



	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_bl_participante")
	@SequenceGenerator(name = "sequence_bl_participante", sequenceName = "seq_bl_participante", allocationSize = 1, schema = "dbo", catalog = Entidades.CATALOGO_DB)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "bl_nro_bl", nullable = false)
	public Bl getBl() {
		return this.bl;
	}

	public void setBl(Bl bl) {
		this.bl = bl;
	}

	@Column(name = "tipo_participante", nullable = false, length = 5)
	public String getTipoParticipante() {
		return this.tipoParticipante;
	}

	public void setTipoParticipante(String tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}

	@Column(name = "tipo_id", length = 3)
	public String getTipoId() {
		return this.tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	@Column(name = "nacion_id", length = 2)
	public String getNacionId() {
		return this.nacionId;
	}

	public void setNacionId(String nacionId) {
		this.nacionId = nacionId;
	}

	@Column(name = "valor_id")
	public String getValorId() {
		return this.valorId;
	}

	public void setValorId(String valorId) {
		this.valorId = valorId;
	}

	@Column(name = "nombres", nullable = false)
	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		if(nombres!=null) {
			this.nombres = nombres.toUpperCase();
		}else {
			this.nombres = nombres;
		}
		
	}

	@Column(name = "codigo_pais", length = 2)
	public String getCodigoPais() {
		return this.codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	@Column(name = "codigo_almacen")
	public String getCodigoAlmacen() {
		return this.codigoAlmacen;
	}

	public void setCodigoAlmacen(String codigoAlmacen) {
		this.codigoAlmacen = codigoAlmacen;
	}

	@Column(name = "direccion")
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		if(direccion!=null) {
			this.direccion = direccion.toUpperCase();
		}else {
			this.direccion = direccion;
		}
		
	}

	@Column(name = "comuna")
	public String getComuna() {
		return this.comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	@Column(name = "telefono")
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}