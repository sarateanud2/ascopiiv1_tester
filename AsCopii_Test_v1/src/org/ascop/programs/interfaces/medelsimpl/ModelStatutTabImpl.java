package org.ascop.programs.interfaces.medelsimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

import org.ascop.programs.enitys.StatutTab;
import org.ascop.programs.interfaces.medels.ModelStatutTab;
import org.ascop.programs.interfaces.services.ServiceStatutTab;

@ManagedBean(name="modelStatutTab", eager=true)
@SessionScoped
public class ModelStatutTabImpl implements ModelStatutTab, Converter {
	
	@ManagedProperty("#{serviceStatutTab}")
	private ServiceStatutTab services;
	
	public ServiceStatutTab getServices() {
		return services;
	}

	public void setServices(ServiceStatutTab services) {
		this.services = services;
	}

	private List<SelectItem> selectItems = new ArrayList<SelectItem>();
	private List<StatutTab> statutTabList;
	private Map<Long, StatutTab> map;
	
	@PostConstruct
	public void init() {
		map = new HashMap<>();
		statutTabList = this.getAllStatutTab();
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

	public List<StatutTab> getStatutTabList() {
		return statutTabList;
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return map.get(Long.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((StatutTab) arg2).getId().toString();
	}
	
	

}
