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

public class ProjectLeader extends LeaveHandler {

	@Override
	public String applyLeave(Leave leave) {
		//Project Leader can approve up to 14 days, otherwise it will pass to the HR
        if(leave.getNumberOfDays() <= 14){
            //Employee tier should be 3 or above to get approved
            if(leave.getEmpTier() <= 3){
    			return String.format("Your %1$s leave for employee Tier %2$d level & %3$d of days applied  - APPROVED by ProjectLeader", leave.getLeaveType(), leave.getEmpTier(), leave.getNumberOfDays());
            }else{
                return String.format("Your %1$s leave for employee Tier %2$d level is too low for request %3$d days",leave.getLeaveType(), leave.getEmpTier(), leave.getNumberOfDays());
            }
        }else{
            return supervisor.applyLeave(leave);
        }
	}

}
