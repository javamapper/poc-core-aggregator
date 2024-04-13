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
package org.poc.behaviour.dp.chain.of.responsibility;

import static org.poc.behaviour.dp.cof.associate.process.EmployeeWorkflowCheckPoint.ACCESS_REVOKE;
import static org.poc.behaviour.dp.cof.associate.process.EmployeeWorkflowCheckPoint.COMPANY_ASSETS;
import static org.poc.behaviour.dp.cof.associate.process.EmployeeWorkflowCheckPoint.DOCUMENTATION;
import static org.poc.behaviour.dp.cof.associate.process.EmployeeWorkflowCheckPoint.EXIT_COMMUNICATION;
import static org.poc.behaviour.dp.cof.associate.process.EmployeeWorkflowCheckPoint.EXIT_INTERVIEW;
import static org.poc.behaviour.dp.cof.associate.process.EmployeeWorkflowCheckPoint.F_AND_F_SETTLEMENT;
import static org.poc.behaviour.dp.cof.associate.process.EmployeeWorkflowCheckPoint.KT;
import static org.poc.behaviour.dp.cof.associate.process.EmployeeWorkflowCheckPoint.SALARY_NEGOTIATION;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.poc.behaviour.dp.cof.associate.process.Associate;
import org.poc.behaviour.dp.cof.associate.process.Associate.EmployeeType;
import org.poc.behaviour.dp.cof.associate.process.AssociateRoleType;
import org.poc.behaviour.dp.cof.associate.process.DBTableAPIHelper;
import org.poc.behaviour.dp.cof.associate.process.EmployeeProcessChecklistChain;
import org.poc.behaviour.dp.cof.associate.process.EmployeeWorkflowCheckPoint;
import org.poc.behaviour.dp.cof.associate.process.WorkFlowHandler;

public class EmployeeExitProcessApp {
	public static enum EmpWorkFlowType {EXIT, JOIN}
	
	static List<EmployeeWorkflowCheckPoint> listOfExitWFPoints = Arrays.asList(EXIT_COMMUNICATION, DOCUMENTATION, KT,
			COMPANY_ASSETS, ACCESS_REVOKE, F_AND_F_SETTLEMENT, SALARY_NEGOTIATION, EXIT_INTERVIEW);
	
	public static void main(String[] args) {
		Associate associate = new Associate(202L, EmployeeType.FULL_TIME,AssociateRoleType.ENGINEER,"Anil Kumar");
		
		
		WorkFlowHandler workFlowHandler = new WorkFlowHandler();
		Map<String, String> transformUpdateStatusInDB = DBTableAPIHelper.transformUpdateStatusInDB(DBTableAPIHelper.getListDataFrames(associate.getAssociateId(), EmpWorkFlowType.EXIT));
		EmployeeProcessChecklistChain employeeProcessChecklistChain = new EmployeeProcessChecklistChain(transformUpdateStatusInDB);
		workFlowHandler.processWorkflow(associate.getAssociateId(), EmpWorkFlowType.EXIT, employeeProcessChecklistChain);
	}
	
}
