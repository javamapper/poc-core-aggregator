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

import org.poc.behaviour.dp.strategy.beans.DEVICE_TYPE;
import org.poc.behaviour.dp.strategy.beans.DashbordTrayStrategy;
import org.poc.behaviour.dp.strategy.beans.DeviceDetail;
import org.poc.behaviour.dp.strategy.beans.HistoryDataAnalysisStrategy;
import org.poc.behaviour.dp.strategy.beans.SearchLogHistoryDataAnalysisStrategy;
import org.poc.behaviour.dp.strategy.beans.TrandingDataAnalysisStrategy;
import org.poc.behaviour.dp.strategy.beans.UserDetail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyDesignPatternApp {

	public static void main(String[] args) {
		UserDetail userDetail = new UserDetail("U324");
		DeviceDetail deviceDetail = new DeviceDetail(DEVICE_TYPE.PHONE);
		log.info("Dashbord of youTube generating based on different Strategy:");
		DashbordTrayStrategy dashbordTrayStrategy = new HistoryDataAnalysisStrategy();
		TrayResourceCreator trayResourceCreator = new TrayResourceCreator(dashbordTrayStrategy);
		trayResourceCreator.executeStrategy(userDetail,deviceDetail);
		
		trayResourceCreator.setStrategy(new SearchLogHistoryDataAnalysisStrategy());
		trayResourceCreator.executeStrategy(userDetail,deviceDetail);
		
		trayResourceCreator.setStrategy(new TrandingDataAnalysisStrategy());
		trayResourceCreator.executeStrategy(userDetail,deviceDetail);
		
	}
}
