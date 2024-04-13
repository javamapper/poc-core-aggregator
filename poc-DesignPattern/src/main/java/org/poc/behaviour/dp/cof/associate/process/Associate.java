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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Associate implements GenericAssociate {
	public enum EmployeeType {FULL_TIME, PART_TIME};
	private Long associateId;
	private EmployeeType employeeType;
	private AssociateRoleType associateRoleType;
	private String name;
}
