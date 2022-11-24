package com.palindrome.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.palindrome.service.IPalindromeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author RamGopalVarma
 *
 */
@Service
@Slf4j
public class PalindromeServiceImpl implements IPalindromeService {

	private static final Logger logger = LoggerFactory.getLogger(PalindromeServiceImpl.class);

	/**
	 * @param num
	 * @return Integer value
	 */
	@Override
	public String nearestPalindrome(String number) {
		logger.info("Entered into PalindromeServiceImpl::nearestPalindrome {}", number);
		return closestPalindrome(number);
	}

	/**
	 * @param num
	 * @return Integer value
	 */
	public String closestPalindrome(String n) {
		logger.info("Entered into PalindromeServiceImpl::closestPalindrome {}", n);
		long num = Long.parseLong(n);
		for (long i = 1;; i++) {
			if (isPalindrome(num - i))
				return "" + (num - i);
			if (isPalindrome(num + i))
				return "" + (num + i);
		}
	}

	/**
	 * @param s
	 * @return boolean value
	 */
	public static boolean isPalindrome(long x) {
		logger.info("Entered into PalindromeServiceImpl::isPalindrome {}", x);
		long t = x, rev = 0;
		while (t > 0) {
			rev = 10 * rev + t % 10;
			t /= 10;
		}
		logger.info("End of PalindromeServiceImpl::isPalindrome {}", x);
		return rev == x;

	}
	/**
	 * @param s
	 * @return String value
	 */
	@Override
	public String nearestPalindromeEffectiveApproch(String n) {
		logger.info("Entered into PalindromeServiceImpl::nearestPalindromeEffectiveApproch {}", n);
		if (n.equals("1"))
			return "0";

		String a = checkReverse(n);
		long diff1 = Long.MAX_VALUE;
		diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
		if (diff1 == 0)
			diff1 = Long.MAX_VALUE;

		StringBuilder s = new StringBuilder(n);
		int i = (s.length() - 1) / 2;
		while (i >= 0 && s.charAt(i) == '0') {
			s.replace(i, i + 1, "9");
			i--;
		}
		if (i == 0 && s.charAt(i) == '1') {
			s.delete(0, 1);
			int mid = (s.length() - 1) / 2;
			s.replace(mid, mid + 1, "9");
		} else
			s.replace(i, i + 1, "" + (char) (s.charAt(i) - 1));
		String b = checkReverse(s.toString());
		long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));

		s = new StringBuilder(n);
		i = (s.length() - 1) / 2;
		while (i >= 0 && s.charAt(i) == '9') {
			s.replace(i, i + 1, "0");
			i--;
		}
		if (i < 0) {
			s.insert(0, "1");
		} else
			s.replace(i, i + 1, "" + (char) (s.charAt(i) + 1));
		String c = checkReverse(s.toString());
		long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));

		if (diff2 <= diff1 && diff2 <= diff3)
			return b;
		if (diff1 <= diff3 && diff1 <= diff2)
			return a;
		else
			return c;
	}
	/**
	 * @param s
	 * @return String value
	 */
	public String checkReverse(String s) {
		logger.info("Entered into PalindromeServiceImpl::checkReverse {}", s);
		String x = s.substring(0, (s.length()) / 2);
		return x + (s.length() % 2 == 1 ? s.charAt(s.length() / 2) : "") + new StringBuilder(x).reverse().toString();
	}
}
