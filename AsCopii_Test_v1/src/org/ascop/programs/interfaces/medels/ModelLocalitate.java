package org.ascop.programs.interfaces.medels;

import java.util.List;

import org.ascop.programs.enitys.Localitate;

public interface ModelLocalitate {
	List<Localitate> getAllLocalitate();
	void addStrada(Localitate localitate);
	void updateStrada(Localitate localitate);
}
