package org.ascop.programs.abstracts.enitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass
public abstract class Parinte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="second_name")
	private String secondName;
	
	@Column(name="data_nasterii")
	@Temporal(TemporalType.DATE)
	private Date data_nastere;
	
	@Column(name="data_deces")
	@Temporal(TemporalType.DATE)
	private Date dataDeces;
	
	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Date getData_nastere() {
		return data_nastere;
	}

	public void setData_nastere(Date data_nastere) {
		this.data_nastere = data_nastere;
	}

	public Date getDataDeces() {
		return dataDeces;
	}

	public void setDataDeces(Date dataDeces) {
		this.dataDeces = dataDeces;
	}
	
}
