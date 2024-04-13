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

import org.poc.behaviour.dp.chain.of.responsibility.entity.Associate;
import org.poc.behaviour.dp.chain.of.responsibility.entity.HR;
import org.poc.behaviour.dp.chain.of.responsibility.entity.Leave;
import org.poc.behaviour.dp.chain.of.responsibility.entity.LeaveType;
import org.poc.behaviour.dp.chain.of.responsibility.entity.Manager;
import org.poc.behaviour.dp.chain.of.responsibility.entity.ProjectLeader;
import org.poc.behaviour.dp.chain.of.responsibility.entity.TeamLeader;

public class LeaveRequestApproverApp {
	public static void main(String[] args) {
		Associate associate = new Associate();
		TeamLeader teamLeader = new TeamLeader();
        ProjectLeader projectLeader = new ProjectLeader();
        HR hr = new HR();
        Manager manager = new Manager();

        associate.setSuperVisor(teamLeader);
        teamLeader.setSuperVisor(projectLeader);
        projectLeader.setSuperVisor(hr);
        hr.setSuperVisor(manager);

        Leave leave1 = new Leave(2,4, LeaveType.SICK);
        System.out.println(associate.applyLeave(leave1));
        
        Leave leave2 = new Leave(5,4, LeaveType.REGULAR);
        System.out.println(associate.applyLeave(leave2));

        Leave leave3 = new Leave(5,5, LeaveType.REGULAR);
        System.out.println(associate.applyLeave(leave3));

        Leave leave4 = new Leave(12,3, LeaveType.REGULAR);
        System.out.println(associate.applyLeave(leave4));

        Leave leave5 = new Leave(18,2, LeaveType.CRITICAL);
        System.out.println(associate.applyLeave(leave5));

        Leave leave6 = new Leave(18,2, LeaveType.REGULAR);
        System.out.println(associate.applyLeave(leave6));

        Leave leave7 = new Leave(30,2, LeaveType.SPECIAL);
        System.out.println(associate.applyLeave(leave7));
	}
}
