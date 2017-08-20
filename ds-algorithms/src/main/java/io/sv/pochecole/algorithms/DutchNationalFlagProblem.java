package io.sv.pochecole.algorithms;

import java.util.Arrays;

/***
 * 
 * @author rv250129
 * Dutch National Flag Problem Description:
 * When you are given an array of numbers, for example like the one below, you need to segregate them into three groups of 0s, 1s and 2s. 
 * 
 * Input: {1,1,0,0,2,2,1,1,0,0,2,2,2,1,1,0,1,2,0,1,2,0,1,2}
 *
 *Output: {1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2}	
 * 
 * Solve this problem with O(N) time complexity.
 *
 *Solution:
 */
public class DutchNationalFlagProblem {

	private static void swap(int []a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	private static int [] solveDutch(int []a){

		int low=0; 
		int high = a.length-1;
		int mid = 0;

		while (mid <=high){

			switch (a[mid]){

				case 0: {
					swap (a, low, mid);
					low++;
					mid++;	
					break;
				}
				case 1: {
					mid++;
					break;
				}
	
				case 2:{
					swap(a, mid, high);
					high--;
					break;
				}

			}
		}
		return a;
	}

	public static void main(String[] args) {

		int []a = {1,1,0,0,2,2,1,1,0,0,2,2,2,1,1,0,1,2,0,1,2,0,1,2};
		System.out.println("Given Array: " + Arrays.toString(a));
		a = DutchNationalFlagProblem.solveDutch(a);
		System.out.println("After solving: " + Arrays.toString(a));

	}

}
