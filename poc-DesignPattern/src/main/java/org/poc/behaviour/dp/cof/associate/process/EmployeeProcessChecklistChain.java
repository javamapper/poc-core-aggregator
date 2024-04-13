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

import java.util.Map;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeProcessChecklistChain {
	private Map<String, String> workFlowUpdateFlag;

	public EmployeeProcessChecklistChain(Map<String, String> checkListMapFlag) {
		workFlowUpdateFlag = checkListMapFlag;
	}

	public Optional<Status> next(Long associateId, EmployeeWorkflowCheckPoint employeeWorkflowCheckPoint, EmployeeProcessChecklistChain chain) {
		if (employeeWorkflowCheckPoint.getStatus().equals(Status.REQUIRED)) {
			// stop next process to check
			if(Status.COMPLETED.name().equalsIgnoreCase(workFlowUpdateFlag.get(employeeWorkflowCheckPoint.name()))){
				log.info("Already approved for {} WorkflowCheckpoint", employeeWorkflowCheckPoint.name());
				return Optional.of(Status.COMPLETED);
			}else {
				/**
				 * request a API call to collect fresh status and update to DB as well as next process
				 */
				log.info("Notifying team {} for approval of {}", employeeWorkflowCheckPoint.getTeamEmailGroupId(), employeeWorkflowCheckPoint.name());
				String status = DBTableAPIHelper.collectInformationFromApiCall(associateId, employeeWorkflowCheckPoint.name());
				this.workFlowUpdateFlag.put(employeeWorkflowCheckPoint.name(),status);
				Optional<Status> statusReturn = status.equalsIgnoreCase(Status.COMPLETED.name()) ? Optional.of(Status.COMPLETED) : Optional.of(Status.PENDING);
				log.info("Collected status {} for {} WorkflowCheckpoint approval", statusReturn.get().name(), employeeWorkflowCheckPoint.name());
				return statusReturn;
			}
		} else {
			return Optional.of(Status.COMPLETED);
		}
	}
}
