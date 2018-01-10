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
import org.ascop.programs.enitys.CategArt8Tab;
import org.ascop.programs.interfaces.medels.ModelCategoriiArtOpt;
import org.ascop.programs.interfaces.services.ServiceCategoriiArtOpt;


@ManagedBean(name="modelCategoriiArtOpt", eager=true)
@SessionScoped
public class ModelCategoriiArtOptImpl implements ModelCategoriiArtOpt, Converter {
	
	
	@ManagedProperty("#{servicesCategArtOpt}")
	private ServiceCategoriiArtOpt services;
	
	private List<SelectItem> selectItems = new ArrayList<SelectItem>();
	private Map<Integer, CategArt8Tab> map;
	private List<CategArt8Tab> categList;
	
	
	
//	===================== GET/SET for services ==============================
	
	public ServiceCategoriiArtOpt getServices() {
		return services;
	}

	public void setServices(ServiceCategoriiArtOpt services) {
		this.services = services;
	}
	
	public List<CategArt8Tab> getCategList() {
		return categList;
	}	

//	===========================================================================	
	


	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		map = new HashMap<>();
		
		categList = this.getAllCategoriiArtOpt();
		Collections.sort(categList, ListComparator.getInstance());
		categList.forEach(cat -> {	map.put(cat.getId(), cat);
			 						selectItems.add(new SelectItem(cat, cat.getDescription()));
			 					});
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

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String strId) {
		
		return map.get(Integer.valueOf(strId));
		/*return this.services.findById(Integer.valueOf(strId));*/
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((CategArt8Tab) arg2).getId().toString();
	}

}
