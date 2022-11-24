package com.palindrome.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.palindrome.service.IPalindromeService;

/**
 * @author RamGopalVarma
 *
 */
@RestController
@Validated
public class PalindromeController {
	private static final Logger logger = LoggerFactory.getLogger(PalindromeController.class);
	
	@Autowired
	private IPalindromeService palindromeService;
	
	/**
	 * @param number
	 * @return String value
	 */
	@GetMapping("/palindrome")
	public String palindrome(@RequestParam String number) {
		logger.info("Entered into PalindromeController::palindrome {}",number);
		return palindromeService.nearestPalindrome(number);
	}
	/**
	 * @param number
	 * @return String value
	 */
	@GetMapping("/palindromeEffectiveApproach")
	public String palindromeEffectiveApproach(@RequestParam String number) {
		logger.info("Entered into PalindromeController::palindrome {}",number);
		return palindromeService.nearestPalindromeEffectiveApproch(number);
	}
}
