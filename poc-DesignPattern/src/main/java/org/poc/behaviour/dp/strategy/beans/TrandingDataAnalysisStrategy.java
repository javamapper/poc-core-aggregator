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
package org.poc.behaviour.dp.strategy.beans;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrandingDataAnalysisStrategy implements DashbordTrayStrategy {

	@Override
	public void execute(String userId) {
		log.info("execute data strategy for - userId {}",userId);
	}

}
