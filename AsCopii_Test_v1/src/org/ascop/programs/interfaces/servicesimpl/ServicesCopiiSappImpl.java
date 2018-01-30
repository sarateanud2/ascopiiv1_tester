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
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void updateCopil(CopiiiSapp copii) {
		StringBuilder queryBuilder = new StringBuilder();
		
		queryBuilder.append("Update CopiiiSapp set ");
		queryBuilder.append("nume = :nume, ");
		queryBuilder.append("prenume = :prenume, ");
		queryBuilder.append("dataNasterii = :dataNasterii, ");
		queryBuilder.append("dataEvidenta = :dataEvidenta, ");
		queryBuilder.append("categArt8Tab = :categArt8Tab, ");
		queryBuilder.append("statutTab = :statutTab, ");
		queryBuilder.append("formaProtectie = :formaProtectie, ");
		queryBuilder.append("localitateBean = :localitateBean, ");
		queryBuilder.append("stradaBean = :stradaBean, ");
		queryBuilder.append("nrCasa = :nrCasa, ");
		queryBuilder.append("app = :app, ");
		queryBuilder.append("dataScoateriiEvident = :dataScoateriiEvident, ");
		queryBuilder.append("note = :note ");
		queryBuilder.append("where id = :id");
		
		Query query = em.createQuery(queryBuilder.toString());
		
		query.setParameter("nume", copii.getNume());
		query.setParameter("prenume", copii.getPrenume());
		query.setParameter("dataNasterii", copii.getDataNasterii());
		query.setParameter("dataEvidenta", copii.getDataEvidenta());
		query.setParameter("categArt8Tab", copii.getCategArt8Tab());
		query.setParameter("statutTab", copii.getStatutTab());
		query.setParameter("formaProtectie", copii.getFormaProtectie());
		query.setParameter("localitateBean", copii.getLocalitateBean());
		query.setParameter("stradaBean", copii.getStradaBean());
		query.setParameter("nrCasa", copii.getNrCasa());
		query.setParameter("app", copii.getApp());
		query.setParameter("dataScoateriiEvident", copii.getDataScoateriiEvident());
		query.setParameter("note", copii.getNote());		
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
