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

import org.poc.behaviour.dp.chain.of.responsibility.EmployeeExitProcessApp.EmpWorkFlowType;


public class WorkFlowHandler {
	
	static List<EmployeeWorkflowCheckPoint> listOfExitWFPoints = Arrays.asList(EXIT_COMMUNICATION, DOCUMENTATION, KT,
			COMPANY_ASSETS, ACCESS_REVOKE, F_AND_F_SETTLEMENT, SALARY_NEGOTIATION, EXIT_INTERVIEW);
	
	public void processWorkflow(Long associateId, EmpWorkFlowType empWorkFlowType, EmployeeProcessChecklistChain chain) {
		if(empWorkFlowType.equals(EmpWorkFlowType.EXIT)){
			listOfExitWFPoints.stream().anyMatch(employeeWorkflowCheckPoint-> chain.next(associateId, employeeWorkflowCheckPoint, chain).get().equals(Status.PENDING));
		}
	}
	
}
