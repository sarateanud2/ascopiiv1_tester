package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the forma_protectie database table.
 * 
 */
@Entity
@Table(name="forma_protectie")
@NamedQuery(name="FormaProtectie.findAll", query="SELECT f FROM FormaProtectie f")
public class FormaProtectie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String prescurate;

	//bi-directional many-to-one association to CopiiiSapp
	@OneToMany(mappedBy="formaProtectie")
	private List<CopiiiSapp> copiiiSapps;

	public FormaProtectie() {
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

	public String getPrescurate() {
		return this.prescurate;
	}

	public void setPrescurate(String prescurate) {
		this.prescurate = prescurate;
	}

	public List<CopiiiSapp> getCopiiiSapps() {
		return this.copiiiSapps;
	}

	public void setCopiiiSapps(List<CopiiiSapp> copiiiSapps) {
		this.copiiiSapps = copiiiSapps;
	}

	public CopiiiSapp addCopiiiSapp(CopiiiSapp copiiiSapp) {
		getCopiiiSapps().add(copiiiSapp);
		copiiiSapp.setFormaProtectie(this);

		return copiiiSapp;
	}

	public CopiiiSapp removeCopiiiSapp(CopiiiSapp copiiiSapp) {
		getCopiiiSapps().remove(copiiiSapp);
		copiiiSapp.setFormaProtectie(null);

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
		FormaProtectie other = (FormaProtectie) obj;
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