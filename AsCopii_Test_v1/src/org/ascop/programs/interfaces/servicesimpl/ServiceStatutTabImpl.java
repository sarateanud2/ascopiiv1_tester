package org.ascop.programs.interfaces.servicesimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ascop.programs.enitys.StatutTab;
import org.ascop.programs.interfaces.services.ServiceStatutTab;
import org.springframework.stereotype.Component;

@Component("serviceStatutTab")
public class ServiceStatutTabImpl implements ServiceStatutTab {
	
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
	public List<StatutTab> getAllStatutTab() {
		return this.em.createQuery("SELECT s FROM StatutTab s").getResultList();
	}

}
