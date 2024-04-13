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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.poc.behaviour.dp.chain.of.responsibility.EmployeeExitProcessApp.EmpWorkFlowType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBTableAPIHelper {

	public static List<DataFrameOfStatus> getListDataFrames(Long associateId,EmpWorkFlowType empWorkFlowType){
		List<DataFrameOfStatus> dataFrameOfStatus = new LinkedList<>();
		if(empWorkFlowType.equals(EmpWorkFlowType.EXIT)){
			 //return listOfExitWFPoints.stream().map(employeeWorkflowCheckPoint -> new DataFrameOfStatus(associateId,null,employeeWorkflowCheckPoint,Status.PENDING)).collect(Collectors.toList());
			dataFrameOfStatus.add(new DataFrameOfStatus(associateId,null,"EXIT_COMMUNICATION","COMPLETED"));
		}
		return dataFrameOfStatus;
	}
	
	public static Map<String,String> transformUpdateStatusInDB(List<DataFrameOfStatus> dataFrameOfStatus){
		Map<String,String> updatedStatusInDB = new LinkedHashMap<>();
		dataFrameOfStatus.stream().forEach(dfs -> updatedStatusInDB.put(dfs.getEmployeeWorkflowStepName(), dfs.getRequestStatus()));	
		return updatedStatusInDB;
	}
	
	public static String collectInformationFromApiCall(Long associateId,String stageName) {
		try {
			log.info("Waiting for associate {} of status {}... ", associateId, stageName);
			System.out.print("Start[          ]");
			System.out.flush(); // the flush method prints it to the screen

			// 11 '\b' chars: 1 for the ']', the rest are for the spaces
			System.out.print("\b\b\b\b\b\b\b\b\b\b\b");
			System.out.flush();

			Thread.sleep(500);

			for (int i = 0; i < 10; i++) {
				System.out.print("."); // overwrites a space
				System.out.flush();
				Thread.sleep(100);
			}

			System.out.print("] Done\n"); // overwrites the ']' + adds chars
			System.out.flush();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // just to make it easy to see the changes

		Map<String, String> statusFromAPI = new HashMap<>();
		statusFromAPI.putIfAbsent("DOCUMENTATION", "COMPLETED");
		statusFromAPI.putIfAbsent("KT", "COMPLETED");
		statusFromAPI.putIfAbsent("COMPANY_ASSETS", "COMPLETED");
		statusFromAPI.putIfAbsent("ACCESS_REVOKE", "COMPLETED");
		statusFromAPI.putIfAbsent("F_AND_F_SETTLEMENT", "PENDING");
//		statusFromAPI.putIfAbsent("SALARY_NEGOTIATION", "PENDING");
//		statusFromAPI.putIfAbsent("EXIT_INTERVIEW", "PENDING");
		return statusFromAPI.get(stageName);
	}
}
