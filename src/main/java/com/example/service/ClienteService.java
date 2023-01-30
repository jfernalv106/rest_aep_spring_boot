package com.example.service;

import java.util.List;

import com.example.model.Cliente;

public interface ClienteService {

	void guardar(Cliente cliente);

	List<Cliente> listaClientes();

}
