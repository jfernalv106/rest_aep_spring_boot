package com.example.service;

import com.example.model.Manifiesto;

public interface ManifiestoService {

	void guardar(Manifiesto manifiesto);

	Manifiesto manifiestobyNroInterno(String nroManifiesto);

	Manifiesto manifiestobyNro(String nro);

}
