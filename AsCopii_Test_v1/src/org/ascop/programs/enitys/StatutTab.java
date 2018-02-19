package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;

import org.ascop.programs.abstracts.enitys.CopilBaseModelUsed;

import java.util.List;


/**
 * The persistent class for the statut_tab database table.
 * 
 */
@Entity
@Table(name="statut_tab")
@NamedQuery(name="StatutTab.findAll", query="SELECT s FROM StatutTab s")
public class StatutTab implements Serializable {
	public List<CopilBaseModelUsed> getCopilBaseModelUseds() {
		return copilBaseModelUseds;
	}

	public void setCopilBaseModelUseds(List<CopilBaseModelUsed> copilBaseModelUseds) {
		this.copilBaseModelUseds = copilBaseModelUseds;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String prescurtare;

	//bi-directional many-to-one association to CopiiiSapp
	@OneToMany(mappedBy="statutTab")
	private List<CopiiiSapp> copiiiSapps;
	
	@OneToMany(mappedBy="statutTab")
	private List<CopilBaseModelUsed> copilBaseModelUseds;

	public StatutTab() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrescurtare() {
		return this.prescurtare;
	}

	public void setPrescurtare(String prescurtare) {
		this.prescurtare = prescurtare;
	}

	public List<CopiiiSapp> getCopiiiSapps() {
		return this.copiiiSapps;
	}

	public void setCopiiiSapps(List<CopiiiSapp> copiiiSapps) {
		this.copiiiSapps = copiiiSapps;
	}

	public CopiiiSapp addCopiiiSapp(CopiiiSapp copiiiSapp) {
		getCopiiiSapps().add(copiiiSapp);
		copiiiSapp.setStatutTab(this);

		return copiiiSapp;
	}

	public CopiiiSapp removeCopiiiSapp(CopiiiSapp copiiiSapp) {
		getCopiiiSapps().remove(copiiiSapp);
		copiiiSapp.setStatutTab(null);

		return copiiiSapp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatutTab other = (StatutTab) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return description;
	}
	
	

}