package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BlDao;
import com.example.model.Bl;
import com.example.service.BlService;

import jakarta.transaction.Transactional;

@Service
public class BlServiceImpl implements BlService{
	
	@Autowired
	BlDao blDao;
	
	@Transactional
	@Override
	public void guardar(Bl bl) {
		blDao.guardar(bl);
	}
	@Transactional
	@Override
	public List<Bl> listaBlsByManifiesto(String manifiesto) {
		return blDao.listaBlsByManifiesto(manifiesto);
	}
}
