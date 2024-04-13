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

public class Manager extends LeaveHandler{

	@Override
	public String applyLeave(Leave leave) {
		 //Only Manager has the authority to approve more than 21 days
        if (leave.getNumberOfDays() > 21) {
            //Employee tier should be 2 or above & reason type should be "Special" to get approved
            if (leave.getEmpTier() <= 2 && leave.getLeaveType().equals(LeaveType.SPECIAL)) {
    			return String.format("Your %1$s leave for employee Tier %2$d level & %3$d of days applied  - APPROVED by Manager", leave.getLeaveType(), leave.getEmpTier(), leave.getNumberOfDays());
            }
        }
            return String.format("Your %1$s leave for %2$d of days applied  - DENIED by Manager", leave.getLeaveType(), leave.getNumberOfDays());
	}

}
