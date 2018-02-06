package org.ascop.programs.enitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TestTab1
 *
 */
@Entity
@Table(name="test_tab1")
public class TestTab1 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="raione_type")
	private String raionType;
	
	@OneToMany(mappedBy="tab1")
	private List<TestTab2> test2;
	
	public String getRaionType() {
		return raionType;
	}
	public void setRaionType(String raionType) {
		this.raionType = raionType;
	}
	public TestTab1() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
}
