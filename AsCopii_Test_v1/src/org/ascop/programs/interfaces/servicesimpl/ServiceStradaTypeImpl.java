package org.ascop.programs.interfaces.servicesimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ascop.programs.enitys.StradaType;
import org.ascop.programs.interfaces.services.ServiceStradaType;
import org.springframework.stereotype.Component;

@Component("serviceStradaType")
public class ServiceStradaTypeImpl implements ServiceStradaType {

	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StradaType> getAllStradaType() {
		return this.em.createQuery("SELECT s FROM StradaType s").getResultList();
	}
	
}
