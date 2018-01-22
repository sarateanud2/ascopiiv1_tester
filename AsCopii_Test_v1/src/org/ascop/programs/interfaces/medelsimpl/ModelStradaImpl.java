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
import org.ascop.programs.enitys.Strada;
import org.ascop.programs.interfaces.medels.ModelStrada;
import org.ascop.programs.interfaces.services.ServiceStrada;


@ManagedBean(name="modelStrada", eager=true)
@SessionScoped
public class ModelStradaImpl implements ModelStrada, Converter {
	
	@ManagedProperty("#{serviceStrada}")
	private ServiceStrada service;
	private List<SelectItem> selectItems = new ArrayList<>();
	private Map<Integer, Strada> map;
	private List<Strada> stradaList;
	
	public ServiceStrada getService() {
		return service;
	}

	public void setService(ServiceStrada service) {
		this.service = service;
	}
	
	public List<SelectItem> getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		map = new HashMap<>();
		stradaList = this.getAllStrada();
		Collections.sort(stradaList, ListComparator.getInstance());
		stradaList.forEach(str -> {
									map.put(str.getId(), str);
									selectItems.add(new SelectItem(str, str.getStrada()));
									});
	}

	@Override
	public List<Strada> getAllStrada() {
		return this.service.getAllStrada();
	}

	@Override
	public void addStrada(Strada str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStrada(Strada str) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return map.get(Integer.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((Strada) arg2).getId().toString();
	}

}
