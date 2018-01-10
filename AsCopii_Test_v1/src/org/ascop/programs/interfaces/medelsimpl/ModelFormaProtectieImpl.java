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

import org.ascop.programs.enitys.FormaProtectie;
import org.ascop.programs.interfaces.medels.ModelFormaProtectie;
import org.ascop.programs.interfaces.services.ServiceFormaProtectie;

@ManagedBean(name="modelFormaProtectie", eager=true)
@SessionScoped
public class ModelFormaProtectieImpl implements ModelFormaProtectie, Converter {

	@ManagedProperty("#{serviceFormaProtectie}")
	private ServiceFormaProtectie service;
	
	public ServiceFormaProtectie getService() {
		return service;
	}

	public void setService(ServiceFormaProtectie service) {
		this.service = service;
	}

	private List<SelectItem> selectItems = new ArrayList<SelectItem>();
	
	private Map<Long, FormaProtectie> map;
	List<FormaProtectie> formaList;
	
	public List<SelectItem> getSelectItems() {
		return selectItems;
	}
	
	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}
	
	@PostConstruct
	public void init() {
		map = new HashMap<>();
		formaList = this.getAllFormeProtectie();
		formaList.forEach(f -> selectItems.add(new SelectItem(f, f.getDescription())));
	}

	@Override
	public List<FormaProtectie> getAllFormeProtectie() {
		return this.service.getAllFormeProtectie();
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		return map.get(Long.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((FormaProtectie) arg2).getId().toString();
	}

}
