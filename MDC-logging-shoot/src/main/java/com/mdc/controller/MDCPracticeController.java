package com.mdc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/mdc/")
@Slf4j
public class MDCPracticeController {
	
	@GetMapping("check")
	public void checkMDCLogging() {
		log.info("<<<<<<<< checkMDCLogging()");
		log.info("PROCESSING HEAVY CODE");
		log.info("checkMDCLogging() >>>>>>>>>");
	}
	
}
