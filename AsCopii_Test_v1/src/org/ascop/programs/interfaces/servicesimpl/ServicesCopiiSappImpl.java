package org.ascop.programs.interfaces.servicesimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.ascop.programs.enitys.CopiiiSapp;
import org.ascop.programs.enitys.Parintii;
import org.ascop.programs.interfaces.services.ServicesCopiiSapp;
import org.springframework.stereotype.Component;

@Component("servicesCopiiSapp")
public class ServicesCopiiSappImpl implements ServicesCopiiSapp {
	
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
	public List<CopiiiSapp> getAllCopiiParintiSapp() {
		
		return this.em.createQuery("SELECT c FROM CopiiiSapp c").getResultList();
	}

	@Override
	public void addCopiiParintiList(List<CopiiiSapp> copiiSappList, List<Parintii> parintiSapp) {
		parintiSapp.forEach(parinti -> parinti.setCopiiiSapps(copiiSappList));
		parintiSapp.forEach(p -> this.em.persist(p));

	}

	@Override
	public void updateCopil(CopiiiSapp copii) {
		Query query = em.createQuery("Update CopiiiSapp " +
										"set nume = :nume, " +
										"prenume = :prenume " +
										"where id = :id");
						query.setParameter("nume", copii.getNume());
						query.setParameter("prenume", copii.getPrenume());
						query.setParameter("id", copii.getId());
						query.executeUpdate();

	}

	@Override
	public void deleteCopilSapp(CopiiiSapp copil) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Parintii> getParintiByCopiiSappId(int idCopil) {
		TypedQuery<Parintii> typeQuery = em.createQuery("SELECT p FROM Parintii p join p.copiiiSapps cs where cs.id = ?1", Parintii.class);
		
		return typeQuery.setParameter(1, idCopil).getResultList();
	}

}
