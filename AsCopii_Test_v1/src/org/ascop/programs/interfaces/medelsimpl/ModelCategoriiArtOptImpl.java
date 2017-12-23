package org.ascop.programs.interfaces.medelsimpl;

import java.util.ArrayList;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.ascop.programs.enitys.CategArt8Tab;
import org.ascop.programs.interfaces.medels.ModelCategoriiArtOpt;
import org.ascop.programs.interfaces.services.ServiceCategoriiArtOpt;


@ManagedBean(name="modelCategoriiArtOpt", eager=true)
@SessionScoped
public class ModelCategoriiArtOptImpl implements ModelCategoriiArtOpt {
	
	
	@ManagedProperty("#{servicesCategArtOpt}")
	private ServiceCategoriiArtOpt services;
	
	private List<SelectItem> selectItems = new ArrayList<SelectItem>();
	
	
//	===================== GET/SET for services ==============================
	
	public ServiceCategoriiArtOpt getServices() {
		return services;
	}

	public void setServices(ServiceCategoriiArtOpt services) {
		this.services = services;
	}

//	===========================================================================	
	
	@PostConstruct
	public void init() {
		List<CategArt8Tab> categList = this.getAllCategoriiArtOpt();
		 categList.forEach(cat -> selectItems.add(new SelectItem(cat, cat.getDescription())));
	}
	
	@Override
	public List<CategArt8Tab> getAllCategoriiArtOpt() {
		
		return this.services.getAllCategoriiArtOpt();
	}

	public List<SelectItem> getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}
	
	
	
	

	

}
