package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the statut_tab database table.
 * 
 */
@Entity
@Table(name="statut_tab")
@NamedQuery(name="StatutTab.findAll", query="SELECT s FROM StatutTab s")
public class StatutTab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String prescurtare;

	//bi-directional many-to-one association to CopiiiSapp
	@OneToMany(mappedBy="statutTab")
	private List<CopiiiSapp> copiiiSapps;

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

}