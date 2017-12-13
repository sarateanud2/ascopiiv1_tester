package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the strada database table.
 * 
 */
@Entity
@NamedQuery(name="Strada.findAll", query="SELECT s FROM Strada s")
public class Strada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String strada;

	//bi-directional many-to-one association to CopiiiSapp
	@OneToMany(mappedBy="stradaBean")
	private List<CopiiiSapp> copiiiSapps;

	//bi-directional many-to-one association to StradaType
	@ManyToOne
	@JoinColumn(name="strada_type")
	private StradaType stradaTypeBean;

	public Strada() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStrada() {
		return this.strada;
	}

	public void setStrada(String strada) {
		this.strada = strada;
	}

	public List<CopiiiSapp> getCopiiiSapps() {
		return this.copiiiSapps;
	}

	public void setCopiiiSapps(List<CopiiiSapp> copiiiSapps) {
		this.copiiiSapps = copiiiSapps;
	}

	public CopiiiSapp addCopiiiSapp(CopiiiSapp copiiiSapp) {
		getCopiiiSapps().add(copiiiSapp);
		copiiiSapp.setStradaBean(this);

		return copiiiSapp;
	}

	public CopiiiSapp removeCopiiiSapp(CopiiiSapp copiiiSapp) {
		getCopiiiSapps().remove(copiiiSapp);
		copiiiSapp.setStradaBean(null);

		return copiiiSapp;
	}

	public StradaType getStradaTypeBean() {
		return this.stradaTypeBean;
	}

	public void setStradaTypeBean(StradaType stradaTypeBean) {
		this.stradaTypeBean = stradaTypeBean;
	}

}