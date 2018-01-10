package org.ascop.programs.interfaces.services;

import java.util.List;

import org.ascop.programs.enitys.CategArt8Tab;

public interface ServiceCategoriiArtOpt {
	List<CategArt8Tab> getAllCategoriiArtOpt();
	List<CategArt8Tab> findById(int id);
}
