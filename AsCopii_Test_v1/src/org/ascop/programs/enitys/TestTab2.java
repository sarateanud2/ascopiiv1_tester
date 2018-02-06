package org.ascop.programs.enitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="test_tab2")
public class TestTab2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="raion_description")
	private String raionDescription;
	
	@ManyToOne
	@JoinColumn(name="raione_type")
	private TestTab1 tab1;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRaionDescription() {
		return raionDescription;
	}

	public void setRaionDescription(String raionDescription) {
		this.raionDescription = raionDescription;
	}

	public TestTab1 getTab1() {
		return tab1;
	}

	public void setTab1(TestTab1 tab1) {
		this.tab1 = tab1;
	}
	
	

}
