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
package org.poc.behaviour.dp.chain.of.responsibility.entity;

public class Associate extends LeaveHandler{

	@Override
	public String applyLeave(Leave leave) {
		if(leave.getNumberOfDays()<=2 && LeaveType.SICK.equals(leave.getLeaveType())) {
			return String.format("Your %1$s leave for %2$d of days applied - granted", leave.getLeaveType(), leave.getNumberOfDays());
		}else {
			return supervisor.applyLeave(leave);
		}
	}

}
