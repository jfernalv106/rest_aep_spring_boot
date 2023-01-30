package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ClienteDao;
import com.example.model.Cliente;
import com.example.service.ClienteService;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteDao clientesDao;

	@Transactional
	@Override
	public void guardar(Cliente cliente) {
		clientesDao.guardar(cliente);
	}
	


	@Transactional
	@Override
	public List<Cliente> listaClientes() {
		return clientesDao.listaClientes();
	}
}
