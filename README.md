Request URLs:

	Approach #1   http://localhost:8080/palindrome?number=123
	Approach #2   http://localhost:8080/palindromeEffectiveApproach?number=123

Swagger URL:

	http://localhost:8080/swagger-ui.html
	
Enable linting/formatting #
1. As Eclipse has default formatting in it we can use that.
	Short Cut Key: Go to Source | Format Document or press Ctrl+Shift+F
Approach #1

-> Time complexity : O(\sqrt{n})O( n ). Upto 2*\sqrt{n}2∗ n  numbers could be generated in the worst case.
   
   Space complexity : O(1)O(1). Constant space is used.

The simplest solution is to consider every possible number smaller than the given number nn, 
starting by decrementing 1 from the given number and go on in descending order.
Similarly, we can consider every possible number greater than nn starting by incrementing 1 from 
the given number and going in ascending order. We can continue doing so in an alternate manner 
till we find a number which is a palindrome

Approach #2 Using Math  Algorithm 

-> Time complexity : O(l)O(l). Scanning, insertion, deletion,, mirroring takes O(l)O(l), where ll is the length of the
string.

   Space complexity : O(l)O(l). Temporary variables are used to store the strings.

 Assume that the number given to us is "abcxy". 
 
 1.One way to convert this number into a palindrome is to replicate one half of the string to the other half. 
 2.If we try replicating the second half to the first half, the new palindrome obtained will be "yxcxy" 
 which lies at an absolute of \left|10000(a-y) + 1000(b-x)\right|∣10000(a−y)+1000(b−x)∣ from the original number. 
 But, if we replicate the first half to the second half of the string, we obtain "abcba", which lies at an 
 absolute difference of \left|10(x-b) + (y-a)\right|∣10(x−b)+(y−a)∣. 
 
3.Trying to change cc additionaly in either case would incur an additional value of atleast 100 in
 the absolute difference.

4.we can conclude that if replication is used to generate the palindromic number, 
we should always replicate the first half to the second half. 
5.In this implementation, we've stored such a number in aa at a difference of diff1diff1 from nn.

But, there exists another case as well, where the digit at the middle index is incremented or decremented. 
In such cases, it could be profitable to make changes to the central digit only 
since such changes could lead to a palindrome formation nearer to the original digit. 
e.g. 10987. Using the above criteria, the palindrome obtained will be 10901 
which is at a more difference from 10987 than 11011. A similar situation occurs if a 0 occurs at the middle digit. 
But, again as discussed previously, we need to consider only the first half digits to obtain the new palindrome. 
This special effect occurs with 0 or 9 at the middle digit since, only decrementing 0 and incrementing 9 at 
that digit place can lead to the change in the rest of the digits towards their left. In any other case, 
the situation boils down to the one discussed in the first paragraph.

6.Now, whenever we find a 0 near the middle index, in order to consider the palindromes 
which are lesser than nn, we subtract a 1 from the first half of the number to obtain a new palindromic half 
e.g. If the given number nn is 20001, we subtract a 1 from 200 creating a number of the form 199xx. 
To obtain the new palindrome, we replicate the first half to obtain 19991. 
Taking another example of 10000, (with a 1 at the MSB), we subtract a 1 from 100 creating 099xx as 
the new number transforming to a 9999 as the new palindrome. 
This number is stored in bb having a difference of diff2diff2 from nn

7.Similar treatment needs to be done with a 9 at the middle digit, 
except that this time we need to consider the numbers larger than the current number. 
For this, we add a 1 to the first half. e.g. Taking the number 10987, 
we add a 1 to 109 creating a number of the form 110xx(11011 is the new palindrome). 
This palindrome is stored in cc having a difference of diff3diff3 from nn.

Out of these three palindromes, we can choose the one with a minimum difference from nn. 
Further, in case of a tie, we need to return the smallest palindrome obtained. 
For resolving this tie's conflict, we can observe that a tie is possible only if one number is larger 
than nn and another is lesser than nn. Further, we know that the number bb is obtained by decreasing nn. 
Thus, in case of conflict between bb and any other number, we need to choose bb. 
Similarly, cc is obtained by increasing nn. Thus, in case of a tie between cc and any other number, 
we need to choose the number other than cc.



