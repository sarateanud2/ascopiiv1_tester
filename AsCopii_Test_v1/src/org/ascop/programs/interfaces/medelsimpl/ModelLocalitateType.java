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
import org.ascop.programs.enitys.LocalitateTypes;
import org.ascop.programs.interfaces.services.ServiceLocalitateTypes;

@ManagedBean(name="modelLocalitateType", eager=true)
@SessionScoped
public class ModelLocalitateType implements org.ascop.programs.interfaces.medels.ModelLocalitateType, Converter {

	@ManagedProperty("#{serviceLocalitateTypes}")
	private ServiceLocalitateTypes service;
	private List<LocalitateTypes> localitateType;
	private Map<Integer, LocalitateTypes> map;
	private List<SelectItem> selectedItem = new ArrayList<>();
	
	public ServiceLocalitateTypes getService() {
		return service;
	}

	public void setService(ServiceLocalitateTypes service) {
		this.service = service;
	}

	public List<LocalitateTypes> getLocalitateType() {
		return localitateType;
	}

	public void setLocalitateType(List<LocalitateTypes> localitateType) {
		this.localitateType = localitateType;
	}

	public List<SelectItem> getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(List<SelectItem> selectedItem) {
		this.selectedItem = selectedItem;
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		map = new HashMap<>();
		localitateType = service.getAllLocalitateTypes();
		Collections.sort(localitateType, ListComparator.getInstance());
		localitateType.forEach(lt -> {
										map.put(lt.getId(), lt);
										selectedItem.add(new SelectItem(lt, lt.getTypeLocalitatess()));
		});
	}

	@Override
	public List<LocalitateTypes> getAllLocalitateType() {
		return this.service.getAllLocalitateTypes();
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return map.get(Integer.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((LocalitateTypes) arg2).getId().toString();
	}

}
