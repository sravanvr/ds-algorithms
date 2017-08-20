package io.sv.pochecole.algorithms;

import java.util.HashSet;

/***
 * This problem is asked in Google Interviews.
 * 
 * Problem: Find if there any pairs of numbers in this array whose sum is equivalent to given a value.
 * 
 * Example 1:
 * Input: A Sorted array like this {1,2,3,4,9} Sum=8   
 * Answer: Answer in this case is "No".  
 * 
 * Example2:
 * Input:Sorted Array {1,2,4,4}
 * Answer: Since 4+4=8, answer is "Yes"
 *
 */

public class NumberPairsInArray {

	private static boolean doesPairsExist(int a[], int sum){

		int n = a.length;

		for (int i=0; i<n; i++){
			for (int j=i+1; j<n; j++){
				if (a[i] + a[j] ==sum)
					return true;
			}
		}
		return false;
	}

	// Use two pointers from both ends
	private static boolean doesPairsExist2(int a[], int sum){

		int i = 0;
		int j = a.length-1;
				
		while (i<j){
			if (a[i] + a[j] == sum){
				return true;
			}
			else if (a[i]+a[j] > sum){
				j--;
				continue;
			}
			else if (a[i]+a[j] < sum){
				i++;
				continue;
			}
		}
		
		return false;
	}

	// Use two pointers from both ends
	private static boolean doesPairsExist3(int a[], int sum){

		HashSet<Integer> compliments = new HashSet<Integer>();
		
		for(int i =0; i< a.length; i++){
			int c = sum-a[i];
			if (compliments.contains(a[i])){
				return true;
			}
			else{
				compliments.add(c);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		boolean r;
		int a[] = {-100,-10,30,35,36,37,40,55,60,70,80,90}; 
		int b[] = {-100,-10,30,35,36,37,40,50,60,70,80,90}; 
		int c[] = {2,5,12,15,18,22,30,35}; 

		r = NumberPairsInArray.doesPairsExist2(a, -65);
		System.out.println(r);

		r = NumberPairsInArray.doesPairsExist2(b, -110);
		System.out.println(r);
		
		r = NumberPairsInArray.doesPairsExist3(b, -110);
		System.out.println(r);

	}

}
