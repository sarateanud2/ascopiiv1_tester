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
	private LocalitateTypes localitateTypeBean;

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

	public LocalitateTypes getLocalitateTypeBean() {
		return this.localitateTypeBean;
	}

	public void setLocalitateTypeBean(LocalitateTypes localitateTypeBean) {
		this.localitateTypeBean = localitateTypeBean;
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
		Localitate other = (Localitate) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  localitateTypeBean.getTypeLocalitatess() + " " + denumire;
	}
	
	

}