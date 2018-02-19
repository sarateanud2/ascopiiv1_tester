package org.ascop.programs.abstracts.enitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.ascop.programs.enitys.Localitate;
import org.ascop.programs.enitys.Raion;
import org.ascop.programs.enitys.Strada;
import org.ascop.programs.enitys.TipParinte;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ParinteBaseModelUsed extends Parinte {
	
	@ManyToOne
	@JoinColumn(name="tip")
	private TipParinte tipParinte;

	private String note;
	
	@ManyToOne
	@JoinColumn(name="raion")
	private Raion raion;
	
	@ManyToOne
	@JoinColumn(name="strada")
	private Strada stradaBean;
	
	@ManyToOne
	@JoinColumn(name="localitate")
	private Localitate localitateBean;
	
	@Column(name="nr_casa")
	private String nrCasa;
	
	private String apartament;
	
	@Column(name="nr_tel")
	private String nrTel;
	
	@ManyToMany
	@JoinTable(
			name="copii_base_model_parinti"
			, joinColumns = {
				@JoinColumn(name="parinti_base_model_fk")
				}
			, inverseJoinColumns = {
					@JoinColumn(name="copil_base_model_fk")
			})
	private List<CopilBaseModelUsed> copilBaseModelUseds;

	public TipParinte getTipParinte() {
		return tipParinte;
	}

	public void setTipParinte(TipParinte tipParinte) {
		this.tipParinte = tipParinte;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Raion getRaion() {
		return raion;
	}

	public void setRaion(Raion raion) {
		this.raion = raion;
	}

	public Strada getStradaBean() {
		return stradaBean;
	}

	public void setStradaBean(Strada stradaBean) {
		this.stradaBean = stradaBean;
	}

	public Localitate getLocalitateBean() {
		return localitateBean;
	}

	public void setLocalitateBean(Localitate localitateBean) {
		this.localitateBean = localitateBean;
	}

	public String getNrCasa() {
		return nrCasa;
	}

	public void setNrCasa(String nrCasa) {
		this.nrCasa = nrCasa;
	}

	public String getApartament() {
		return apartament;
	}

	public void setApartament(String apartament) {
		this.apartament = apartament;
	}

	public String getNrTel() {
		return nrTel;
	}

	public void setNrTel(String nrTel) {
		this.nrTel = nrTel;
	}

	public List<CopilBaseModelUsed> getCopilBaseModelUseds() {
		return copilBaseModelUseds;
	}

	public void setCopilBaseModelUseds(List<CopilBaseModelUsed> copilBaseModelUseds) {
		this.copilBaseModelUseds = copilBaseModelUseds;
	}
	
}
