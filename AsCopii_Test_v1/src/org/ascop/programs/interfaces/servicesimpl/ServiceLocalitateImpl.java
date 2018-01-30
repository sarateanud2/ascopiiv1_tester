package org.ascop.programs.interfaces.servicesimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ascop.programs.enitys.Localitate;
import org.ascop.programs.interfaces.services.ServiceLocalitate;
import org.springframework.stereotype.Component;

@Component("serviceLocalitate")
public class ServiceLocalitateImpl implements ServiceLocalitate {
	
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
	public List<Localitate> getAllLocalitate() {
		return this.em.createQuery("Select loc from Localitate loc").getResultList();
	}

	@Override
	public void addStrada(Localitate localitate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStrada(Localitate localitate) {
		// TODO Auto-generated method stub

	}
	
	

}
