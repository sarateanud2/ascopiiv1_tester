package org.ascop.programs.interfaces.services;

import java.util.List;

import org.ascop.programs.enitys.Strada;

public interface ServiceStrada {
	
	List<Strada> getAllStrada();
	void addStrada(Strada str);
	void updateStrada(Strada str);
	
}
