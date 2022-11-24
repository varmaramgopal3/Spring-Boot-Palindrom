package com.palindrome.service;

/**
 * @author RamGopalVarma
 *
 */
public interface IPalindromeService {

	/**
	 * @param number
	 * @return String
	 */
	public String nearestPalindrome(String number);

	/**
	 * @param n
	 * @return String
	 */
	public String nearestPalindromeEffectiveApproch(String number);

}
