package org.ascop.programs.enitys.recreate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.ascop.programs.abstracts.enitys.CopilBaseModelUsed;

@Entity
@Table(name="copil_conflict_lege")
public class CopilConflictLege extends CopilBaseModelUsed implements Serializable {

	private static final long serialVersionUID = 1L;

}
