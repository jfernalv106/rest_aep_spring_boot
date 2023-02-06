package com.example.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.ManifiestoDao;
import com.example.model.Manifiesto;

@Repository
public class ManifiestoDaoImpl implements ManifiestoDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void guardar(Manifiesto manifiesto) {
		 sessionFactory.getCurrentSession().persist(manifiesto);
	}

	@Override
	public Manifiesto manifiestobyNroInterno(String nroManifiesto) {
		String query = "FROM Manifiesto as mn WHERE mn.nroMftoInterno=:nroManifiesto ";
		return sessionFactory.getCurrentSession().createQuery( query,Manifiesto.class).setParameter("nroManifiesto", nroManifiesto).uniqueResult();
	}
	@Override
	public Manifiesto manifiestobyNro(String nro) {
		String query = "FROM Manifiesto as mn WHERE mn.nroMfto=:nro ";
		return sessionFactory.getCurrentSession().createQuery( query,Manifiesto.class).setParameter("nro", nro).uniqueResult();
	}
}
