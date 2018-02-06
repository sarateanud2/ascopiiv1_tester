package org.ascop.programs.enitys;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: RaionType
 *
 */
@Entity
@Table(name="raion_type")

public class RaionType implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="raion_type")
	private String raionType;
	
	@OneToMany(mappedBy="raionType")
	private List<Raion> raion;
	
	public RaionType() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getRaionType() {
		return this.raionType;
	}

	public void setRaionType(String raionType) {
		this.raionType = raionType;
	}
	public List<Raion> getRaion() {
		return raion;
	}
	public void setRaion(List<Raion> raion) {
		this.raion = raion;
	}
	
	
   
}
