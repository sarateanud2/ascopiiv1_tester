package org.ascop.programs.enitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.ascop.programs.abstracts.enitys.CopilBaseModelUsed;
import org.ascop.programs.abstracts.enitys.ParinteBaseModelUsed;

/**
 * Entity implementation class for Entity: Raion
 *
 */
@Entity
@Table(name="raion")
public class Raion implements Serializable {

	public List<CopilBaseModelUsed> getCopilBaseModelUseds() {
		return copilBaseModelUseds;
	}

	public void setCopilBaseModelUseds(List<CopilBaseModelUsed> copilBaseModelUseds) {
		this.copilBaseModelUseds = copilBaseModelUseds;
	}

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
	
	@OneToMany(mappedBy="raion")
	private List<ParinteBaseModelUsed> parinteBaseModelUseds;
	
	@OneToMany(mappedBy="raion")
	private List<CopilBaseModelUsed> copilBaseModelUseds;
	
	public List<ParinteBaseModelUsed> getParinteBaseModelUseds() {
		return parinteBaseModelUseds;
	}

	public void setParinteBaseModelUseds(List<ParinteBaseModelUsed> parinteBaseModelUseds) {
		this.parinteBaseModelUseds = parinteBaseModelUseds;
	}

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
