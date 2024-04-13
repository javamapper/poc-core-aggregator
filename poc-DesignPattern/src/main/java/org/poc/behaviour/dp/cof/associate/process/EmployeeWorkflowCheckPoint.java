/*
 * Coding practice lab
 *
 * Website Url: https://github.com/javamapper/io
 * Base Repo Url: https://github.com/javamapper
 * Linkedin profile: https://www.linkedin.com/in/anilref12/
 * 
 * v1.0
 *
 * 2024-03-18
 * 
 * This file is copyrighted - 
 *
 * Please appreciate if this put value in your knowledge and work
 * 
*/
package org.poc.behaviour.dp.cof.associate.process;

import static org.poc.behaviour.dp.cof.associate.process.AssociateRoleType.*;
import java.util.Arrays;
import java.util.List;

public enum EmployeeWorkflowCheckPoint {
	//These value will dynamically fetch from DB table
	
	EXIT_COMMUNICATION(Arrays.asList(HR, PROJECT_MGR), Status.REQUIRED, "exit_communication@poc.com"), 
	DOCUMENTATION(Arrays.asList(HR, PROJECT_MGR), Status.REQUIRED, "exit_document@poc.com"), 
	KT(Arrays.asList(TL, PROJECT_MGR), Status.REQUIRED, "dependency_valiadtor@poc.com"), 
	COMPANY_ASSETS(Arrays.asList(HR, ASSET_MGR), Status.REQUIRED, "asset_management@poc.com"), 
	ACCESS_REVOKE(Arrays.asList(HR, ACCESS_MGR), Status.REQUIRED, "access_management@poc.com"), 
	F_AND_F_SETTLEMENT(Arrays.asList(HR, ADMIN), Status.REQUIRED, "admin@poc.com"), 
	SALARY_NEGOTIATION(Arrays.asList(HR, PROJECT_MGR, HR_MGR), Status.REQUIRED, "hr_team@poc.com"), 
	EXIT_INTERVIEW(Arrays.asList(HR, HR_MGR), Status.REQUIRED, "hr_group@poc.com");
	
	private final List<AssociateRoleType> associateRoleTypes;
	private final Status status;
	private final String teamEmailGroupId;
	
	EmployeeWorkflowCheckPoint(List<AssociateRoleType> approverAssociateRoleTypes, Status status, String teamEmailGroupId) {
		this.associateRoleTypes = approverAssociateRoleTypes;
		this.status = status;
		this.teamEmailGroupId = teamEmailGroupId;
	}

	public List<AssociateRoleType> getAssociateRoleTypes() {
		return associateRoleTypes;
	}

	public Status getStatus() {
		return status;
	}

	public String getTeamEmailGroupId() {
		return teamEmailGroupId;
	}
}
