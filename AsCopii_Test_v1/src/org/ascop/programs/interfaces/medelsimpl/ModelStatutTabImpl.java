package org.ascop.programs.interfaces.medelsimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.ascop.programs.enitys.StatutTab;
import org.ascop.programs.interfaces.medels.ModelStatutTab;
import org.ascop.programs.interfaces.services.ServiceStatutTab;

@ManagedBean(name="modelStatutTab", eager=true)
@SessionScoped
public class ModelStatutTabImpl implements ModelStatutTab {
	
	@ManagedProperty("#{serviceStatutTab}")
	private ServiceStatutTab services;
	
	public ServiceStatutTab getServices() {
		return services;
	}

	public void setServices(ServiceStatutTab services) {
		this.services = services;
	}

	private List<SelectItem> selectItems = new ArrayList<SelectItem>();
	
	@PostConstruct
	public void init() {
		List<StatutTab> statutTabList = this.getAllStatutTab();
		statutTabList.forEach(stat -> selectItems.add(new SelectItem(stat, stat.getDescription())));
	}

	@Override
	public List<StatutTab> getAllStatutTab() {
		return this.services.getAllStatutTab();
	}
	
	public List<SelectItem> getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}

}
