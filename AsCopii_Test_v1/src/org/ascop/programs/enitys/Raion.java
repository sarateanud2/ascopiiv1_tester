package org.ascop.programs.enitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="raion")
public class Raion implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String denumire;
	
	@ManyToOne
	@JoinColumn(name="raion_type")
	private RaionTypes raionTypes;
	
	@OneToMany(mappedBy="raion")
	private List<CopiiiSapp> copiiiSapps;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public RaionTypes getRaionType() {
		return raionTypes;
	}

	public void setRaionType(RaionTypes raionType) {
		this.raionTypes = raionType;
	}

	public List<CopiiiSapp> getCopiiiSapps() {
		return copiiiSapps;
	}

	public void setCopiiiSapps(List<CopiiiSapp> copiiiSapps) {
		this.copiiiSapps = copiiiSapps;
	}
	
	
	

}
