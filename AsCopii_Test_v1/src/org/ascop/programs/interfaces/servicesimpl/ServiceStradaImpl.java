package org.ascop.programs.interfaces.servicesimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ascop.programs.enitys.Strada;
import org.ascop.programs.interfaces.services.ServiceStrada;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("serviceStrada")
public class ServiceStradaImpl implements ServiceStrada {
	
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
	public List<Strada> getAllStrada() {
		return this.em.createQuery("SELECT s FROM Strada s").getResultList();
	}

	@Override
	@Transactional
	public void addStrada(Strada str) {
		this.em.persist(str);
	}

	@Override
	@Transactional
	public void updateStrada(Strada str) {
		// TODO Auto-generated method stub

	}

}
