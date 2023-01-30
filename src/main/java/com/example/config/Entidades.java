package com.example.config;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.model.Bl;
import com.example.model.BlAuditoria;
import com.example.model.BlFecha;
import com.example.model.BlFlete;
import com.example.model.BlItem;
import com.example.model.BlItemContenedor;
import com.example.model.BlItemContenedorImo;
import com.example.model.BlItemContenedorSello;
import com.example.model.BlItemEquipo;
import com.example.model.BlItemImo;
import com.example.model.BlItemTipoBulto;
import com.example.model.BlItemVehiculo;
import com.example.model.BlLocacion;
import com.example.model.BlObservacion;
import com.example.model.BlParticipante;
import com.example.model.BlReferencia;
import com.example.model.BlTransbordo;
import com.example.model.BlTransporte;
import com.example.model.BlVersion;
import com.example.model.Cliente;
import com.example.model.DireccionClte;
import com.example.model.Manifiesto;

public class Entidades {

	public final static String CATALOGO_DB = "aep";

	public static LocalSessionFactoryBean cargaClases(LocalSessionFactoryBean factoryBean) {

		/* se agregan clases bean para trabajar con hibernate */
		factoryBean.setAnnotatedClasses(Bl.class,
				BlAuditoria.class,
				BlFecha.class,
				BlFlete.class,
				BlItem.class,
				BlItemContenedor.class,
				BlItemContenedorImo.class,
				BlItemContenedorSello.class,
				BlItemEquipo.class,
				BlItemImo.class,
				BlItemTipoBulto.class,
				BlItemVehiculo.class,
				BlLocacion.class,
				BlObservacion.class,
				BlParticipante.class,
				BlReferencia.class,
				BlTransbordo.class,
				BlTransporte.class,
				BlVersion.class,
				Cliente.class,
				DireccionClte.class,
				Manifiesto.class);

		return factoryBean;
	}
}
