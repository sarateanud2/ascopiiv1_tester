package org.ascop.programs.abstracts.enitys;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ascop.programs.enitys.CategArt8Tab;
import org.ascop.programs.enitys.FormaProtectie;
import org.ascop.programs.enitys.Localitate;
import org.ascop.programs.enitys.Raion;
import org.ascop.programs.enitys.StatutTab;
import org.ascop.programs.enitys.Strada;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class CopilBaseModelUsed extends Copil {
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_evidenta")
	private Date dataEvidenta; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_scoaterii_evident")
	private Date dataScoateriiEvident;
	
	@ManyToOne
	@JoinColumn(name="categoria_art_8")
	private CategArt8Tab categArt8Tab;
		
	@ManyToOne
	@JoinColumn(name="forma_protectie_fk")
	private FormaProtectie formaProtectie;
	
	@ManyToOne
	@JoinColumn(name="localitate")
	private Localitate localitateBean;
	
	@ManyToOne
	@JoinColumn(name="statutul")
	private StatutTab statutTab;

	@ManyToOne
	@JoinColumn(name="strada")
	private Strada stradaBean;
	
	@ManyToOne
	@JoinColumn(name="raion")
	private Raion raion;
	
	@Column(name="nr_casa")
	private String nrCasa;
	
	private String apartament;
	
	@Column(name="nr_tel")
	private String nrTel;
	
	private String note;
	
	@ManyToMany(mappedBy="copilBaseModelUseds")
	private List<ParinteBaseModelUsed> parinteBaseModelUseds;

	public CategArt8Tab getCategArt8Tab() {
		return categArt8Tab;
	}

	public void setCategArt8Tab(CategArt8Tab categArt8Tab) {
		this.categArt8Tab = categArt8Tab;
	}

	public FormaProtectie getFormaProtectie() {
		return formaProtectie;
	}

	public void setFormaProtectie(FormaProtectie formaProtectie) {
		this.formaProtectie = formaProtectie;
	}

	public Localitate getLocalitateBean() {
		return localitateBean;
	}

	public void setLocalitateBean(Localitate localitateBean) {
		this.localitateBean = localitateBean;
	}

	public StatutTab getStatutTab() {
		return statutTab;
	}

	public void setStatutTab(StatutTab statutTab) {
		this.statutTab = statutTab;
	}

	public Strada getStradaBean() {
		return stradaBean;
	}

	public void setStradaBean(Strada stradaBean) {
		this.stradaBean = stradaBean;
	}

	public Raion getRaion() {
		return raion;
	}

	public void setRaion(Raion raion) {
		this.raion = raion;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<ParinteBaseModelUsed> getParinteBaseModelUseds() {
		return parinteBaseModelUseds;
	}

	public void setParinteBaseModelUseds(List<ParinteBaseModelUsed> parinteBaseModelUseds) {
		this.parinteBaseModelUseds = parinteBaseModelUseds;
	}
	
}
