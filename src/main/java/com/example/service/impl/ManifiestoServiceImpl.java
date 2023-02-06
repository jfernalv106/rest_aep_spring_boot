package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ManifiestoDao;
import com.example.model.Manifiesto;
import com.example.service.ManifiestoService;

import jakarta.transaction.Transactional;

@Service
public class ManifiestoServiceImpl implements ManifiestoService{

	@Autowired
	ManifiestoDao manifiestoDao;
	
	@Transactional
	@Override
	public void guardar(Manifiesto manifiesto) {
		manifiestoDao.guardar(manifiesto);
	}
	
	@Transactional
	@Override
	public Manifiesto manifiestobyNroInterno(String nroManifiesto) {
		return manifiestoDao.manifiestobyNroInterno(nroManifiesto);
	}
	@Transactional
	@Override
	public Manifiesto manifiestobyNro(String nro) {
		return manifiestoDao.manifiestobyNro(nro);
	}
}
