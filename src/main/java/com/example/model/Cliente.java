package com.example.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "rut", scope = Cliente.class)
@Table(name = "clientes", schema = "dbo" ,catalog = "aep")
public class Cliente {

	
	private String rut;
	private String razonSocial;
	private String fono;
	private boolean credito;
	private String origen;
	private String contacto;
	private boolean forwarder;
	private boolean vigente;
	private String tipo;
	private String mail;
	private boolean utilizaLiberacion;
	private BigDecimal dolarTecho;
	private BigDecimal dolarPiso;
	private Integer diasCredito;
	private String giro;
	private boolean agNaviera;
	private boolean cliente;
	private boolean convenio;
	private Date fechaCr;
	private Date fechaUp;
	private String usuarioCr;
	private String usuarioUp;
	private String ocrCode;
	private boolean ordenCompra;
	private Boolean cobranzaMatriz;
	private String acuerdo;
	private Set<DireccionClte> direcciones = new HashSet<DireccionClte>(0);


	
	@PrePersist
	public void prePersist() {

		if (razonSocial != null) {
			razonSocial = razonSocial.toUpperCase();
		}
		if (giro != null) {
			giro = giro.toUpperCase();
		}
		
		
	}
	
	@Id
	@Column(name = "rut", unique = true, nullable = false)
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Column(name = "razonZocial")
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	@Column(name = "fono")
	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}


	@Column(name = "origen")
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Column(name = "contacto")
	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	@Column(name = "tipo")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	@Column(name = "dolar_techo")
	public BigDecimal getDolarTecho() {
		return dolarTecho;
	}

	public void setDolarTecho(BigDecimal dolarTecho) {
		this.dolarTecho = dolarTecho;
	}

	@Column(name = "dolar_piso")
	public BigDecimal getDolarPiso() {
		return dolarPiso;
	}

	public void setDolarPiso(BigDecimal dolarPiso) {
		this.dolarPiso = dolarPiso;
	}

	@Column(name = "dias_credito")
	public Integer getDiasCredito() {
		return diasCredito;
	}

	public void setDiasCredito(Integer diasCredito) {
		this.diasCredito = diasCredito;
	}

	@Column(name = "giro")
	public String getGiro() {
		return giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}







	@CreationTimestamp
	@Column(name = "fecha_cr")
	public Date getFechaCr() {
		return fechaCr;
	}

	public void setFechaCr(Date fechaCr) {
		this.fechaCr = fechaCr;
	}

	@UpdateTimestamp
	@Column(name = "fecha_up")
	public Date getFechaUp() {
		return fechaUp;
	}

	public void setFechaUp(Date fechaUp) {
		this.fechaUp = fechaUp;
	}
	@Column(name = "usuario_cr")
	public String getUsuarioCr() {
		return usuarioCr;
	}

	public void setUsuarioCr(String usuarioCr) {
		this.usuarioCr = usuarioCr;
	}
	@Column(name = "usuario_up")
	public String getUsuarioUp() {
		return usuarioUp;
	}

	public void setUsuarioUp(String usuarioUp) {
		this.usuarioUp = usuarioUp;
	}
	@Column(name = "credito")
	public boolean isCredito() {
		return credito;
	}

	public void setCredito(boolean credito) {
		this.credito = credito;
	}
	@Column(name = "forwarder")
	public boolean isForwarder() {
		return forwarder;
	}

	public void setForwarder(boolean forwarder) {
		this.forwarder = forwarder;
	}
	@Column(name = "vigente")
	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}
	@Column(name = "utiliza_liberacion")
	public boolean isUtilizaLiberacion() {
		return utilizaLiberacion;
	}

	public void setUtilizaLiberacion(boolean utilizaLiberacion) {
		this.utilizaLiberacion = utilizaLiberacion;
	}
	@Column(name = "ag_naviera")
	public boolean isAgNaviera() {
		return agNaviera;
	}

	public void setAgNaviera(boolean agNaviera) {
		this.agNaviera = agNaviera;
	}
	@Column(name = "convenio")
	public boolean isConvenio() {
		return convenio;
	}

	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}
	@Column(name = "cliente")
	public boolean isCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	@Column(name = "orden_compra")
	public boolean isOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(boolean ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	
	@Column(name = "acuerdo")
	public String getAcuerdo() {
		return acuerdo;
	}

	public void setAcuerdo(String acuerdo) {
		this.acuerdo = acuerdo;
	}

	@Column(name = "ocr_code")
	public String getOcrCode() {
		return ocrCode;
	}

	public void setOcrCode(String ocrCode) {
		this.ocrCode = ocrCode;
	}

	@Column(name = "cobranza_matriz")
	public Boolean getCobranzaMatriz() {
		return cobranzaMatriz;
	}
	public void setCobranzaMatriz(Boolean cobranzaMatriz) {
		this.cobranzaMatriz = cobranzaMatriz;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", cascade = CascadeType.ALL)
	public Set<DireccionClte> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Set<DireccionClte> direcciones) {
		this.direcciones = direcciones;
	}
	
	
}
