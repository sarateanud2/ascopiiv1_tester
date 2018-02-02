package org.ascop.programs.models;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="modelNavPage", eager = true)
@SessionScoped
public class ModelNavPage {
	
	private String page;
	private String pag_1;
	private String pag_2;
	private String pag_3;
	
	@PostConstruct
	public void init() {
		this.page = "main";
		this.pag_1 = "noactive";
		this.pag_2 = "active";
		this.pag_3 = "noactive";
	}

	public String getPage() {
		if(this.page.equals("main")) {
			this.pag_1 = "active";
			this.pag_2 = "noactive";
			this.pag_3 = "noactive";
		} else if(this.page.equals("copiisapp")) {
			this.pag_1 = "noactive";
			this.pag_2 = "active";
			this.pag_3 = "noactive";
		} else if(this.page.equals("addadones")){
			this.pag_1 = "noactive";
			this.pag_2 = "noactive";
			this.pag_3 = "active";
		}
		
		return page;
	}

	public void setPage(String page) {
		this.page = page;
		
	}

	public String getPag_1() {
		
		
		return pag_1;
	}

	public void setPag_1(String pag_1) {
		this.pag_1 = pag_1;
	}

	public String getPag_2() {
		return pag_2;
	}

	public void setPag_2(String pag_2) {
		this.pag_2 = pag_2;
	}

	public String getPag_3() {
		return pag_3;
	}

	public void setPag_3(String pag_3) {
		this.pag_3 = pag_3;
	}
	
	
}
