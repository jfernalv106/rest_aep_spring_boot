package com.example.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.ClienteDao;
import com.example.model.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void guardar(Cliente cliente) {
		sessionFactory.getCurrentSession().persist(cliente);
	}
	



	@Override
	public List<Cliente> listaClientes() {
		String query = "FROM Cliente as c where c.rut=:rut";
		return sessionFactory.getCurrentSession().createQuery( query,Cliente.class).setParameter("rut", "76329078-6").list();
	}
}
