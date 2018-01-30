package org.ascop.programs.interfaces.servicesimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ascop.programs.interfaces.services.ServiceLocalitateTypes;
import org.ascop.programs.enitys.LocalitateTypes;
import org.springframework.stereotype.Component;

@Component("serviceLocalitateTypes")
public class ServiceLocalitateTypesImpl implements  ServiceLocalitateTypes{

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
	public List<LocalitateTypes> getAllLocalitateTypes() {
		return this.em.createNamedQuery("LocalitateType.findAll").getResultList();
	}
	
	

}
