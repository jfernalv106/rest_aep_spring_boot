package com.example.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.BlDao;
import com.example.model.Bl;

@Repository
public class BlDaoImpl implements BlDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void guardar(Bl bl) {
		 sessionFactory.getCurrentSession().persist(bl);
	}

	@Override
	public List<Bl> listaBlsByManifiesto(String manifiesto) {
		String query = "FROM Bl as b WHERE b.manifiesto.nroMftoInterno=:manifiesto ";
		return sessionFactory.getCurrentSession().createQuery( query,Bl.class).setParameter("manifiesto", manifiesto).list();
	}
}
