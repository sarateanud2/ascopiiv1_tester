package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the localitate database table.
 * 
 */
@Entity
@NamedQuery(name="Localitate.findAll", query="SELECT l FROM Localitate l")
public class Localitate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String denumire;

	//bi-directional many-to-one association to CopiiiSapp
	@OneToMany(mappedBy="localitateBean")
	private List<CopiiiSapp> copiiiSapps;

	//bi-directional many-to-one association to LocalitateType
	@ManyToOne
	@JoinColumn(name="localitate_type")
	private LocalitateType localitateTypeBean;

	public Localitate() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public List<CopiiiSapp> getCopiiiSapps() {
		return this.copiiiSapps;
	}

	public void setCopiiiSapps(List<CopiiiSapp> copiiiSapps) {
		this.copiiiSapps = copiiiSapps;
	}

	public CopiiiSapp addCopiiiSapp(CopiiiSapp copiiiSapp) {
		getCopiiiSapps().add(copiiiSapp);
		copiiiSapp.setLocalitateBean(this);

		return copiiiSapp;
	}

	public CopiiiSapp removeCopiiiSapp(CopiiiSapp copiiiSapp) {
		getCopiiiSapps().remove(copiiiSapp);
		copiiiSapp.setLocalitateBean(null);

		return copiiiSapp;
	}

	public LocalitateType getLocalitateTypeBean() {
		return this.localitateTypeBean;
	}

	public void setLocalitateTypeBean(LocalitateType localitateTypeBean) {
		this.localitateTypeBean = localitateTypeBean;
	}

}