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
@NamedQuery(name="LocalitateType.findAll", query="SELECT l FROM LocalitateType l")
public class LocalitateType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="type_localitate")
	private String typeLocalitate;

	//bi-directional many-to-one association to Localitate
	@OneToMany(mappedBy="localitateTypeBean")
	private List<Localitate> localitates;

	public LocalitateType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeLocalitate() {
		return this.typeLocalitate;
	}

	public void setTypeLocalitate(String typeLocalitate) {
		this.typeLocalitate = typeLocalitate;
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

}