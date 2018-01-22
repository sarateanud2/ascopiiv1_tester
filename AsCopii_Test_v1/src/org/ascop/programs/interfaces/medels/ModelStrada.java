package org.ascop.programs.interfaces.medels;

import java.util.List;

import org.ascop.programs.enitys.Strada;

public interface ModelStrada {
	List<Strada> getAllStrada();
	void addStrada(Strada str);
	void updateStrada(Strada str);
}
