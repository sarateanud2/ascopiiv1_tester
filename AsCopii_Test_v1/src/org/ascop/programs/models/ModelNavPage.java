package org.ascop.programs.models;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="modelNavPage", eager = true)
@SessionScoped
public class ModelNavPage {
	
	private String page;
	
	@PostConstruct
	public void init() {
		this.page = "main";
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	
}
