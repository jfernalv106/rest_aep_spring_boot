package com.example.dao;

import java.util.List;

import com.example.model.Bl;

public interface BlDao {

	void guardar(Bl bl);


	List<Bl> listaBlsByManifiesto(String manifiesto);

}
