package org.ascop.programs.enitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Raion
 *
 */
@Entity
@Table(name="raion")
public class Raion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="prescurtare_raion")
	private String prescurtareRaion;
	
	@Column(name="raion")
	private String raion;
	
	@ManyToOne
	@JoinColumn(name="raion_type")
	private RaionType raionType;
	
	@OneToMany(mappedBy="raion")
	private List<CopiiiSapp> copiiSapp;

	public Raion() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrescurtareRaion() {
		return prescurtareRaion;
	}

	public void setPrescurtareRaion(String prescurtareRaion) {
		this.prescurtareRaion = prescurtareRaion;
	}

	public String getRaion() {
		return raion;
	}

	public void setRaion(String raion) {
		this.raion = raion;
	}

	public RaionType getRaionType() {
		return raionType;
	}

	public void setRaionType(RaionType raionType) {
		this.raionType = raionType;
	}

	public List<CopiiiSapp> getCopiiSapp() {
		return copiiSapp;
	}

	public void setCopiiSapp(List<CopiiiSapp> copiiSapp) {
		this.copiiSapp = copiiSapp;
	}
	
}
