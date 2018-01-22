package org.ascop.programs.interfaces.medelsimpl;

import java.util.ArrayList;
import java.util.Collections;
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

import org.ascop.programs.comparators.ListComparator;
import org.ascop.programs.enitys.StradaType;
import org.ascop.programs.interfaces.medels.ModelStradaType;
import org.ascop.programs.interfaces.services.ServiceStradaType;

@ManagedBean(name="modelStradaType", eager=true)
@SessionScoped
public class ModelStradaTypeImpl implements ModelStradaType, Converter{
	
	@ManagedProperty("#{serviceStradaType}")
	private ServiceStradaType service;
	private List<SelectItem> selectItems = new ArrayList<SelectItem>();
	private Map<Integer, StradaType> map;
	private List<StradaType> stradaTypesList;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		map = new HashMap<>();
		stradaTypesList = this.getAllStradaType();
		Collections.sort(stradaTypesList, ListComparator.getInstance());
		stradaTypesList.forEach(str -> {
										map.put(str.getId(), str);
										selectItems.add(new SelectItem(str, str.getStradaType()));
										});
	}	

	public ServiceStradaType getService() {
		return service;
	}

	public void setService(ServiceStradaType service) {
		this.service = service;
	}

	public List<SelectItem> getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}

	@Override
	public List<StradaType> getAllStradaType() {
		return this.service.getAllStradaType();
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return map.get(Integer.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((StradaType) arg2).getId().toString();
	}

}
