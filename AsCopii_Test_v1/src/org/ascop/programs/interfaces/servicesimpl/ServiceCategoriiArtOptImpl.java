package org.ascop.programs.interfaces.servicesimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ascop.programs.enitys.CategArt8Tab;
import org.ascop.programs.enitys.Parintii;
import org.ascop.programs.interfaces.services.ServiceCategoriiArtOpt;
import org.springframework.stereotype.Component;

@Component("servicesCategArtOpt")
public class ServiceCategoriiArtOptImpl implements ServiceCategoriiArtOpt {

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
	public List<CategArt8Tab> getAllCategoriiArtOpt() {
		return this.em.createQuery("SELECT c FROM CategArt8Tab c").getResultList();
	}

	@Override
	public List<CategArt8Tab> findById(int id) {
		
		TypedQuery<CategArt8Tab> typeQuery = em.createQuery("SELECT c FROM CategArt8Tab c where c.id = ?1", CategArt8Tab.class);
		
		
		
		return typeQuery.setParameter(1, id).getResultList();
	}
	
}
