package org.ascop.programs.interfaces.medelsimpl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.ascop.programs.enitys.CopiiiSapp;
import org.ascop.programs.enitys.Parintii;
import org.ascop.programs.interfaces.services.ServicesCopiiSapp;
import org.primefaces.context.RequestContext;

@ManagedBean(name="modelSapp", eager=true)
@SessionScoped
public class ModelCopiiSapp implements org.ascop.programs.interfaces.medels.ModelCopiiSapp {
	
	@ManagedProperty("#{servicesCopiiSapp}")
	private ServicesCopiiSapp services;
	
	private List<CopiiiSapp> filteredCopiiParinti;
	private List<Parintii> filteredParinti;
    private CopiiiSapp selectedCopillSapp;
    private Parintii selectedParinti;
    private boolean editMode;
    
    
//	===================== GET/SET for services ==============================

	public ServicesCopiiSapp getServices() {
		return services;
	}

	public void setServices(ServicesCopiiSapp services) {
		this.services = services;
	}
    
//	===================== GET/SET for filtered and select ==============================
    
	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	
	public List<CopiiiSapp> getFilteredCopiiParinti() {
		return filteredCopiiParinti;
	}

	public void setFilteredCopiiParinti(List<CopiiiSapp> filteredCopiiParinti) {
		this.filteredCopiiParinti = filteredCopiiParinti;
	}

	public List<Parintii> getFilteredParinti() {
		return filteredParinti;
	}

	public void setFilteredParinti(List<Parintii> filteredParinti) {
		this.filteredParinti = filteredParinti;
	}

	public CopiiiSapp getSelectedCopillSapp() {
		return selectedCopillSapp;
	}

	public void setSelectedCopillSapp(CopiiiSapp selectedCopillSapp) {
		this.selectedCopillSapp = selectedCopillSapp;
	}

	public Parintii getSelectedParinti() {
		return selectedParinti;
	}

	public void setSelectedParinti(Parintii selectedParinti) {
		this.selectedParinti = selectedParinti;
	}
	
//	=========================================================================

	@Override
	public List<CopiiiSapp> getAllCopiiParintiSapp() {
		return this.services.getAllCopiiParintiSapp();
	}

	@Override
	public void addCopiiParintiList(List<CopiiiSapp> copiiSappList, List<Parintii> parintiSapp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCopil(CopiiiSapp copii) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCopilSapp(CopiiiSapp copil) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Parintii> getParintiByCopiiSappId(int id) {
		return this.services.getParintiByCopiiSappId(id);
	}

	@Override
	public void switchEditMode() {
		editMode = true;
        RequestContext.getCurrentInstance().execute("dlgEditCopii.show()");
	}

}
