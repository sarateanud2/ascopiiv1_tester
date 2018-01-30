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
import org.ascop.programs.enitys.Localitate;
import org.ascop.programs.interfaces.medels.ModelLocalitate;
import org.ascop.programs.interfaces.services.ServiceLocalitate;

@ManagedBean(name="modelLocalitate", eager=true)
@SessionScoped
public class ModelLocalitateImpl implements ModelLocalitate, Converter {

	@ManagedProperty("#{serviceLocalitate}")
	private ServiceLocalitate service;
	
	private List<SelectItem> selectedLocalitate = new ArrayList<>();
	private Map<Integer, Localitate> map;
	private List<Localitate> localitateList;
	
	public List<SelectItem> getSelectedLocalitate() {
		return selectedLocalitate;
	}

	public void setSelectedLocalitate(List<SelectItem> selectedLocalitate) {
		this.selectedLocalitate = selectedLocalitate;
	}

	public List<Localitate> getLocalitateList() {
		return localitateList;
	}

	public void setLocalitateList(List<Localitate> localitateList) {
		this.localitateList = localitateList;
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		map = new HashMap<>();
		this.localitateList = service.getAllLocalitate();
		Collections.sort(localitateList, ListComparator.getInstance());
		localitateList.forEach(loc -> {
										map.put(loc.getId(), loc);
										selectedLocalitate.add(new SelectItem(loc, loc.getLocalitateTypeBean().getTypeLocalitatess() + " " + loc.getDenumire()));
		});
		
	}
	
	public ServiceLocalitate getService() {
		return service;
	}

	public void setService(ServiceLocalitate service) {
		this.service = service;
	}

	@Override
	public List<Localitate> getAllLocalitate() {
		
		return null;
	}

	@Override
	public void addStrada(Localitate localitate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStrada(Localitate localitate) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return map.get(Integer.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((Localitate) arg2).getId().toString();
	}

}
