package com.example.dao;

import com.example.model.Manifiesto;

public interface ManifiestoDao {

	void guardar(Manifiesto manifiesto);

	Manifiesto manifiestobyNroInterno(String nroManifiesto);

	Manifiesto manifiestobyNro(String nro);

}
