package org.ascop.programs.enitys.recreate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.ascop.programs.abstracts.enitys.ParinteBaseModelUsed;

@Entity
@Table(name="copii_sapp")
public class CopiiSapp extends ParinteBaseModelUsed implements Serializable{

	private static final long serialVersionUID = 1L;
	
}
