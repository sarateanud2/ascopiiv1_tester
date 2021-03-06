package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the strada_type database table.
 * 
 */
@Entity
@Table(name="strada_type")
@NamedQuery(name="StradaType.findAll", query="SELECT s FROM StradaType s")
public class StradaType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="strada_type")
	private String stradaType;

	//bi-directional many-to-one association to Strada
	@OneToMany(mappedBy="stradaTypeBean")
	private List<Strada> stradas;

	public StradaType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStradaType() {
		return this.stradaType;
	}

	public void setStradaType(String stradaType) {
		this.stradaType = stradaType;
	}

	public List<Strada> getStradas() {
		return this.stradas;
	}

	public void setStradas(List<Strada> stradas) {
		this.stradas = stradas;
	}

	public Strada addStrada(Strada strada) {
		getStradas().add(strada);
		strada.setStradaTypeBean(this);

		return strada;
	}

	public Strada removeStrada(Strada strada) {
		getStradas().remove(strada);
		strada.setStradaTypeBean(null);

		return strada;
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
		StradaType other = (StradaType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return stradaType;
	}
	
	

}