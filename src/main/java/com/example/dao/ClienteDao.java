package com.example.dao;


import java.util.List;

import com.example.model.Cliente;

public interface ClienteDao {

	void guardar(Cliente cliente);

	

	List<Cliente> listaClientes();

}
