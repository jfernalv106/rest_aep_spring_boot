package com.example.service;

import java.util.List;

import com.example.model.Bl;

public interface BlService {

	void guardar(Bl bl);
	List<Bl> listaBlsByManifiesto(String manifiesto);


}
