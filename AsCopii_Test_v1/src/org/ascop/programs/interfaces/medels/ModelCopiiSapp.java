package org.ascop.programs.interfaces.medels;

import java.util.List;

import org.ascop.programs.enitys.CopiiiSapp;
import org.ascop.programs.enitys.Parintii;

public interface ModelCopiiSapp {
	
	List<CopiiiSapp> getAllCopiiParintiSapp();
	List<Parintii> getParintiByCopiiSappId(int id);
	void addCopiiParintiList(List<CopiiiSapp> copiiSappList, List<Parintii> parintiSapp);
	void updateCopil();
	void deleteCopilSapp(CopiiiSapp copil);
	void switchEditMode();
	
}
