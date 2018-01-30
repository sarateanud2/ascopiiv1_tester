package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the localitate_type database table.
 * 
 */
@Entity
@Table(name="localitate_type")
@NamedQuery(name="LocalitateType.findAll", query="SELECT l FROM LocalitateTypes l")
public class LocalitateTypes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="type_localitate")
	private String typeLocalitatess;

	//bi-directional many-to-one association to Localitate
	@OneToMany(mappedBy="localitateTypeBean")
	private List<Localitate> localitates;

	public LocalitateTypes() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeLocalitatess() {
		return this.typeLocalitatess;
	}

	public void setTypeLocalitatess(String typeLocalitate) {
		this.typeLocalitatess = typeLocalitate;
	}

	public List<Localitate> getLocalitates() {
		return this.localitates;
	}

	public void setLocalitates(List<Localitate> localitates) {
		this.localitates = localitates;
	}

	public Localitate addLocalitate(Localitate localitate) {
		getLocalitates().add(localitate);
		localitate.setLocalitateTypeBean(this);

		return localitate;
	}

	public Localitate removeLocalitate(Localitate localitate) {
		getLocalitates().remove(localitate);
		localitate.setLocalitateTypeBean(null);

		return localitate;
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
		LocalitateTypes other = (LocalitateTypes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return typeLocalitatess;
	}
	
	
	
	

}