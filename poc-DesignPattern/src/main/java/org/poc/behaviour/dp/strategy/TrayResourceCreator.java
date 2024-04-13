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
package org.poc.behaviour.dp.strategy;

import org.poc.behaviour.dp.strategy.beans.DashbordTrayStrategy;
import org.poc.behaviour.dp.strategy.beans.DeviceDetail;
import org.poc.behaviour.dp.strategy.beans.UserDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TrayResourceCreator {

	
	private DashbordTrayStrategy strategy;
	
	public void executeStrategy(UserDetail userDetail,DeviceDetail deviceDetail) {
		strategy.execute(userDetail.getUserId()+" appearing in "+deviceDetail.getDeviceType()+"-device");
	}
}
