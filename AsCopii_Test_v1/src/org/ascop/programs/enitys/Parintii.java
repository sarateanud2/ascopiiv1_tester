package org.ascop.programs.enitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the parintii database table.
 * 
 */
@Entity
@NamedQuery(name="Parintii.findAll", query="SELECT p FROM Parintii p")
public class Parintii implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_deces")
	private Date dataDeces;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nasterii")
	private Date dataNasterii;

	private String note;

	private String nume;

	private String prenume;

	//bi-directional many-to-many association to CopiiiSapp
	@ManyToMany
	@JoinTable(
		name="copoii_parinti_sapp_2"
		, joinColumns={
			@JoinColumn(name="parinti_fk")
			}
		, inverseJoinColumns={
			@JoinColumn(name="copii_sapp_fk")
			}
		)
	private List<CopiiiSapp> copiiiSapps;

	//bi-directional many-to-one association to TipParinte
	@ManyToOne
	@JoinColumn(name="tip")
	private TipParinte tipParinte;

	public Parintii() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataDeces() {
		return this.dataDeces;
	}

	public void setDataDeces(Date dataDeces) {
		this.dataDeces = dataDeces;
	}

	public Date getDataNasterii() {
		return this.dataNasterii;
	}

	public void setDataNasterii(Date dataNasterii) {
		this.dataNasterii = dataNasterii;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public List<CopiiiSapp> getCopiiiSapps() {
		return this.copiiiSapps;
	}

	public void setCopiiiSapps(List<CopiiiSapp> copiiiSapps) {
		this.copiiiSapps = copiiiSapps;
	}

	public TipParinte getTipParinte() {
		return this.tipParinte;
	}

	public void setTipParinte(TipParinte tipParinte) {
		this.tipParinte = tipParinte;
	}

}