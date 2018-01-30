package org.ascop.programs.interfaces.services;

import java.util.List;

import org.ascop.programs.enitys.Localitate;



public interface ServiceLocalitate {
	List<Localitate> getAllLocalitate();
	void addStrada(Localitate localitate);
	void updateStrada(Localitate localitate);
}
