package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the forma_protectie database table.
 * 
 */
@Entity
@Table(name="forma_protectie")
@NamedQuery(name="FormaProtectie.findAll", query="SELECT f FROM FormaProtectie f")
public class FormaProtectie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String prescurate;

	//bi-directional many-to-one association to CopiiiSapp
	@OneToMany(mappedBy="formaProtectie")
	private List<CopiiiSapp> copiiiSapps;

	public FormaProtectie() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrescurate() {
		return this.prescurate;
	}

	public void setPrescurate(String prescurate) {
		this.prescurate = prescurate;
	}

	public List<CopiiiSapp> getCopiiiSapps() {
		return this.copiiiSapps;
	}

	public void setCopiiiSapps(List<CopiiiSapp> copiiiSapps) {
		this.copiiiSapps = copiiiSapps;
	}

	public CopiiiSapp addCopiiiSapp(CopiiiSapp copiiiSapp) {
		getCopiiiSapps().add(copiiiSapp);
		copiiiSapp.setFormaProtectie(this);

		return copiiiSapp;
	}

	public CopiiiSapp removeCopiiiSapp(CopiiiSapp copiiiSapp) {
		getCopiiiSapps().remove(copiiiSapp);
		copiiiSapp.setFormaProtectie(null);

		return copiiiSapp;
	}

}