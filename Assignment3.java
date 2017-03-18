/*score: 8 + 0.5(extra credit)
comments: good job! Keep doing!
*/
package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.PrintStream;

/**
 * Created by Rose on 1/27/17.
 * Assignment for your lecture 3. Please finish all the questions under
 * 'Assignment'. Please try to think the extra credit questions. The deadline
 * of this assignment is 02/04/2017 23:59 PST. Please feel free to contact me
 * for any questions. Please write your comments about this assignment in the
 * end.
 */


public class Assignment3 {
    /**
     *  Given an array, reverse the elements within this array and print the result
     *  eg, given{1,2,3,4}, print{4,3,2,1}
     */
    public void reverseArray(int[] nums) {                              //correct
        //write your code here
    	// consider of two corner cases
    	if(nums == null || nums.length <= 1) {
    		return;
    	}  
    	
    	for(int i = 0; i < nums.length / 2; i++) {
    	    int temp = nums[i];
    	    nums[i] = nums[nums.length - 1 - i];
    	    nums[nums.length - 1 - i] = temp;
    	    }

    	System.out.println("The reverseArray is:" + Arrays.toString(nums));
    	
    }

    /**
     *  Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
     *  Assume the integer do not contain any leading zero, except the number 0 itself.
     *  The digits are stored such that the most significant digit is at the head of the array.
     *  eg, given {1,2,9}, return{1,3,0}.
     */
    public int[] plusOne(int[] digits) {                  //correct
        //write your code here
    	for (int i = digits.length - 1; i >= 0; i--){
    		//when every digit less than 9
    		if(digits[i] < 9) { 
    			digits[i] = digits[i] + 1;
    			return digits;
    		}
    		//when the digit is 9, it should turn to 0 since + 1. And then enter to next loop to check the digit before 0
    		else if(digits[i] == 9) {
    			digits[i] = 0; 
    		}   		
    	}
    
    //when every digit is 9 and now they are all turn to 0, we should add a more digit to the first and it == 1
    int[] newNum = new int[digits.length + 1]; 
    newNum[0] = 1;
    return newNum;
}

    /**
     *  Write a program that takes an integer as input and returns all the primes between 1 and that integer(inclusive).
     *  eg, input is 18, you should return{2,3,5,7,11,13,17}
     */
    public int[] generatePrimes(int n) {               //correct
        //write your code here
    	//define a list to store primes
     	List<Integer> ret = new ArrayList<Integer>(); 
     	//looking for all the nums that between 2 and n, using the below method
     	for (int j = 2; j <= n; j++){ 
     		// if it is prime, add it to the result array   
     		if (isPrime(j)) {
     			ret.add(j);  			
     		}
     	}
     	// the return maybe wrong, I don't know how to return the result as a array
     	 return ret.toArray(); 
    }
    
  //here is the method to decide if a num is prime
    public static boolean isPrime(int i) { 
     	    if (i % 2 == 0) {
     	        return false;
     	    }
     	    double sqrt = Math.sqrt(i);
     	    for (int t = 3; t <= sqrt; t += 2) {
     	        if (i % t == 0) {
     	            return false;
     	        }
     	    }
     	    return true;
     	}

  

    /**
     *  Assume you have a method isSubstring which checks if one word is a substring of another.
     *  Given two strings, s1 and s2, write a program to check if s2 is a rotation of s1, using only one call
     *  to isSubstring
     *  eg, "pineapple" is a rotation of "neapplepi"
     */
    public boolean isRotation(String s1, String s2) {                         //wrong
    	 //write your code here
    	//s1 and s2 should have same length and s2 is a substring of s1
    	if ((s1.length() == s2.length()) && isSubstring(s1,s2) == true){ 
    		return true;
    	}
    	return false;
    }
    
    // the method isSubstring
    public static boolean isSubstring(String s1, String s2) {
    	if (s2 == null || s2.length() == 0) return true;
    	if (s1 == null || s1.length() == 0) return false;
    	for (int i = 0; i <= s1.length() - s2.length(); i++) {
    		if (s1.charAt(i) == s2.charAt(2)) {
    			if (s1.substring(i, i + s2.length()).equals(s2)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }

    /**
     *  Given two strings, write a method to decide if one is a permutation of the other
     *  hint: the comparison is case sensitive and whitespace is significant
     */
    public boolean isPermutation(String s1, String s2) {     //correct, but try not to use Arrays.sort() method because it will cause a large time complexity
        //write your code here
    	//make sure s1 and s2 have the same length
    	if (s1.length() == s2.length()) { 
    		// sort of s1 and s2 have the same content, including uppercase lowercase and space
    		if(sort(s1).equals(sort(s2))) { 
    			return true;
    		}
    	}
    	return false;
    }
    
    //define a sort method
    private String sort(String s) {
    	char[] content = s.toCharArray();
    	java.util.Arrays.sort(content);
    	return new String(content); 	
    }

    /**
     *  Write a program to implement encoding and decoding string. The rule is simple: encode successive
     *  repeated characters by the repetition count and the character. For example, the input of encoding()
     *  is "aaaabcccaa", you should return "4a1b3c2a". The decoding of "3e4f2e" returns "eeeffffee". Assume
     *  the string to be encoded consists of letters of the alphabet, with no digits, and the string to be
     *  decoded is a valid encoding.
     */
    public static String encoding(String s) {    //the decoding part is wrong, sb.append(ch).append(count); it will cause compile error
        //write your code here
    	if (s == "" || s == null){
    		return "";
    	}
    	char[] sArr = s.toCharArray();
    	PrintStream sb;
    	for (char s:sArr) {
    		if (!Character.isDigit(s)) {
    			//lastseen = s;
    			sb.append(s);
    		}
    		else {
    			int  n = Integer.parseInt(String.valueOf(s));
    			for (int i = 0; i < n - 1; i++) {
    				sb.append(s);
    			}
    		}
    	}
    	return sb.toString();
    }
    
    public static String decoding(String s) {
        //write your code here
    	//if the string is null
    	if (s == "" || s == null) {
    		return "";
    	//regular cases
    	int count = 0;
    	char ch = 0;
    	PrintStream sb;
    	for(int i = 0; i < s.length(); i++) {
    		if (i == 0) {
    			ch = s.charAt(i);
    			count++;
    		}
    		else {
    			if(ch == s.charAt(i)) {
    				count++;
    			}
    			else{
    				sb.append(ch).append(count);
    				count = 1;
    				ch = s.charAt(i);   				
    			}
    		}
    	}
    	sb.append(ch).append(count);
    	return sb.toString();
    }
  }

    //Extra Credit
    /**
     *Given an m x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * For exmaple, given 1 2 3  , return 7 4 1
     *                    4 5,6           8 5 2
     *                    7,8,9           9 6 3
     *tip: image could be a square or a rectangle.
     */
    public void rotate(int[][] matrix) {
        //write your code here
    	//could not work it out :(
    }

     /**
     *Given a string containing just the characters '(', ')', return the count of valid parentheses. If the
     * intput is not valid, return -1. A valid parentheses is "()". For example, given "(())", return 2;
     * given "(()))", return -1.
     */
     public int countValidParentheses(String s) {    //partly correct, the last three lines are not necessary. You may return max / 2
         //write your code here
    	 char[] chs = s.toCharArray();
    	 int[] value = new int[chs.length];
    	 int open = 0;
    	 int max = 0;
    	 for (int i = 0; i < chs.length; i++) {
    		 if (chs[i] == '(') {
    			 open++;
    		 }
    		 if(chs[i] == ')' && open > 0) {
    			 value[i] = value[i - 1] + 2;
    	     if(i - value[i] > 0) {
    	    	 value[i] += value[i - value[i]];
    	     }
    	     open--;
    		 }
    		 if(value[i] > max) max = value[i];
    	 }
    	 return max;
    	 	{
    		 return -1;
    	 	}
     }
}

    /**
     * Write anything you think about this assignment here. Easy? Difficult? Too many questions? Less fun?
     * You could write any comments here
     * Thank you so much for helping me in learning Java and adjusting the difficulty of assignments for us!
     */
}
