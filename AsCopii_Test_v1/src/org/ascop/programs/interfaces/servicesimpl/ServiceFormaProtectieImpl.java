package org.ascop.programs.interfaces.servicesimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ascop.programs.enitys.FormaProtectie;
import org.ascop.programs.interfaces.services.ServiceFormaProtectie;
import org.springframework.stereotype.Component;

@Component("serviceFormaProtectie")
public class ServiceFormaProtectieImpl implements ServiceFormaProtectie {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<FormaProtectie> getAllFormeProtectie() {
		return em.createQuery("SELECT fp FROM FormaProtectie fp", FormaProtectie.class).getResultList();
	}

}
