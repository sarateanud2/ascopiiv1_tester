package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;
import org.ascop.programs.abstracts.enitys.ParinteBaseModelUsed;

import java.util.List;


/**
 * The persistent class for the tip_parinte database table.
 * 
 */
@Entity
@Table(name="tip_parinte")
@NamedQuery(name="TipParinte.findAll", query="SELECT t FROM TipParinte t")
public class TipParinte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String prescurtare;

	//bi-directional many-to-one association to Parintii
	@OneToMany(mappedBy="tipParinte")
	private List<Parintii> parintiis;
	
	@OneToMany(mappedBy="tipParinte")
	private List<ParinteBaseModelUsed> parinte;
	
	public TipParinte() {
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

	public String getPrescurtare() {
		return this.prescurtare;
	}

	public void setPrescurtare(String prescurtare) {
		this.prescurtare = prescurtare;
	}

	public List<Parintii> getParintiis() {
		return this.parintiis;
	}

	public void setParintiis(List<Parintii> parintiis) {
		this.parintiis = parintiis;
	}

	public Parintii addParintii(Parintii parintii) {
		getParintiis().add(parintii);
		parintii.setTipParinte(this);

		return parintii;
	}

	public Parintii removeParintii(Parintii parintii) {
		getParintiis().remove(parintii);
		parintii.setTipParinte(null);

		return parintii;
	}

}