package org.ascop.programs.interfaces.services;

import java.util.List;

import org.ascop.programs.enitys.CopiiiSapp;
import org.ascop.programs.enitys.Parintii;



public interface ServicesCopiiSapp {
	
	List<CopiiiSapp> getAllCopiiParintiSapp();
	List<Parintii> getParintiByCopiiSappId(int idCopil);
	void addCopiiParintiList(List<CopiiiSapp> copiiSappList, List<Parintii> parintiSapp);
	void updateCopil(CopiiiSapp copii);
	void deleteCopilSapp(CopiiiSapp copil);
}
