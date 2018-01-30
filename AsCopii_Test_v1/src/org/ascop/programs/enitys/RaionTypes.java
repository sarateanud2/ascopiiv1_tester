package org.ascop.programs.enitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="raion_types")
public class RaionTypes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String prescurtare;
	
	private String denumire;
	
	@OneToMany(mappedBy="raionType")
	private List<Raion> raion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrescurtare() {
		return prescurtare;
	}

	public void setPrescurtare(String prescurtare) {
		this.prescurtare = prescurtare;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public List<Raion> getRaion() {
		return raion;
	}

	public void setRaion(List<Raion> raion) {
		this.raion = raion;
	}
	
	

}
