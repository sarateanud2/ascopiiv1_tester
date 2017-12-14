package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the copiii_sapp database table.
 * 
 */
@Entity
@Table(name="copiii_sapp")
@NamedQuery(name="CopiiiSapp.findAll", query="SELECT c FROM CopiiiSapp c")
public class CopiiiSapp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String app;

	@Temporal(TemporalType.DATE)
	@Column(name="data_evidenta")
	private Date dataEvidenta;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nasterii")
	private Date dataNasterii;

	@Temporal(TemporalType.DATE)
	@Column(name="data_scoaterii_evident")
	private Date dataScoateriiEvident;

	private String note;

	@Column(name="nr_casa")
	private String nrCasa;

	private String nume;

	private String prenume;

	//bi-directional many-to-one association to CategArt8Tab
	@ManyToOne
	@JoinColumn(name="categoria_art_8")
	private CategArt8Tab categArt8Tab;

	//bi-directional many-to-one association to FormaProtectie
	@ManyToOne
	@JoinColumn(name="forma_protectie_fk")
	private FormaProtectie formaProtectie;

	//bi-directional many-to-one association to Localitate
	@ManyToOne
	@JoinColumn(name="localitate")
	private Localitate localitateBean;

	//bi-directional many-to-one association to StatutTab
	@ManyToOne
	@JoinColumn(name="statutul")
	private StatutTab statutTab;

	//bi-directional many-to-one association to Strada
	@ManyToOne
	@JoinColumn(name="strada")
	private Strada stradaBean;

	//bi-directional many-to-many association to Parintii
	@ManyToMany(mappedBy="copiiiSapps")
	private List<Parintii> parintiis;

	public CopiiiSapp() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApp() {
		return this.app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Date getDataEvidenta() {
		return this.dataEvidenta;
	}

	public void setDataEvidenta(Date dataEvidenta) {
		this.dataEvidenta = dataEvidenta;
	}

	public Date getDataNasterii() {
		return this.dataNasterii;
	}

	public void setDataNasterii(Date dataNasterii) {
		this.dataNasterii = dataNasterii;
	}

	public Date getDataScoateriiEvident() {
		return this.dataScoateriiEvident;
	}

	public void setDataScoateriiEvident(Date dataScoateriiEvident) {
		this.dataScoateriiEvident = dataScoateriiEvident;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNrCasa() {
		return this.nrCasa;
	}

	public void setNrCasa(String nrCasa) {
		this.nrCasa = nrCasa;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public CategArt8Tab getCategArt8Tab() {
		return this.categArt8Tab;
	}

	public void setCategArt8Tab(CategArt8Tab categArt8Tab) {
		this.categArt8Tab = categArt8Tab;
	}

	public FormaProtectie getFormaProtectie() {
		return this.formaProtectie;
	}

	public void setFormaProtectie(FormaProtectie formaProtectie) {
		this.formaProtectie = formaProtectie;
	}

	public Localitate getLocalitateBean() {
		return this.localitateBean;
	}

	public void setLocalitateBean(Localitate localitateBean) {
		this.localitateBean = localitateBean;
	}

	public StatutTab getStatutTab() {
		return this.statutTab;
	}

	public void setStatutTab(StatutTab statutTab) {
		this.statutTab = statutTab;
	}

	public Strada getStradaBean() {
		return this.stradaBean;
	}

	public void setStradaBean(Strada stradaBean) {
		this.stradaBean = stradaBean;
	}

	public List<Parintii> getParintiis() {
		return this.parintiis;
	}

	public void setParintiis(List<Parintii> parintiis) {
		this.parintiis = parintiis;
	}
	
	public String getAddress() {
		if(this.app != null) {
		
		return this.localitateBean.getLocalitateTypeBean().getTypeLocalitate()+ ". " + this.localitateBean.getDenumire() + ", " +
				this.getStradaBean().getStradaTypeBean().getStradaType()+ " " + this.getStradaBean().getStrada() + " " + this.nrCasa + " " + this.app;
		} else {
			return this.localitateBean.getLocalitateTypeBean().getTypeLocalitate()+ ". " + this.localitateBean.getDenumire() + ", " +
					this.getStradaBean().getStradaTypeBean().getStradaType()+ " " +this.getStradaBean().getStrada() + " " + this.nrCasa;
		}
	}

}