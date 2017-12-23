package org.ascop.programs.interfaces.medelsimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import org.ascop.programs.enitys.FormaProtectie;
import org.ascop.programs.interfaces.medels.ModelFormaProtectie;
import org.ascop.programs.interfaces.services.ServiceFormaProtectie;

public class ModelFormaProtectieImpl implements ModelFormaProtectie {

	@ManagedProperty("serviceFormaProtectie")
	private ServiceFormaProtectie service;
	
	
	
	public ServiceFormaProtectie getService() {
		return service;
	}

	public void setService(ServiceFormaProtectie service) {
		this.service = service;
	}

	private List<SelectItem> selectItems = new ArrayList<SelectItem>();
	
	
	
	public List<SelectItem> getSelectItems() {
		return selectItems;
	}
	
	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}
	
	@PostConstruct
	public void init() {
		List<FormaProtectie> formaList = this.getAllFormeProtectie();
		formaList.forEach(f -> selectItems.add(new SelectItem(f, f.getDescription())));
	}

	@Override
	public List<FormaProtectie> getAllFormeProtectie() {
		return this.service.getAllFormeProtectie();
	}

}
