package io.sv.pochecole.algorithms;

import java.util.Arrays;
/***
 * Problem description:
 * From a sorted array, find a missing number in O(log n) time.
 * This solution uses Binary-Saerch to find the missing number.
 */
public class Test1 {

	private static int a1[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
	private static int a2[] = {0,1,3,4,5,6,7,8,9,10,11};
	private static int a3[] = {0,1,2,4,5,6,7,8,9,10,11};
	private static int a4[] = {0,1,2,3,5,6,7,8,9,10,11};
	private static int a5[] = {0,1,2,3,4,6,7,8,9,10,11};
	private static int a6[] = {0,1,2,3,4,5,7,8,9,10,11};
	private static int a7[] = {0,1,2,3,4,5,6,8,9,10,11};
	private static int a8[] = {0,1,2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,18,19};
	private static int a9[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,18,19};
	private static int a10[] ={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,19};
	private static int a11[] ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		
	private static void call(){
		findMissing(a1);
		System.out.println ("***************************************************");
		findMissing(a2);
		System.out.println ("***************************************************");
		findMissing(a3);
		System.out.println ("***************************************************");
		findMissing(a4);
		System.out.println ("***************************************************");
		findMissing(a5);
		System.out.println ("***************************************************");
		findMissing(a6);
		System.out.println ("***************************************************");
		findMissing(a7);
		System.out.println ("***************************************************");
		findMissing(a8);
		System.out.println ("***************************************************");
		findMissing(a9);
		System.out.println ("***************************************************");
		findMissing(a10);
		System.out.println ("***************************************************");
		findMissing(a11);
		
	}
	private static void findMissing(int a []){

		int mid = a.length/2-1;
		int left = 0;
		int right = a.length -1; 
		System.out.println ("Length: " +right +" / calc mid: " + mid);
		
		System.out.println(Arrays.toString(a));
		
		while (true){

			if (right - left >=2){
				
				mid = left + (right - left)/2;
				//mid = left + (right - left)/2 - 1;

				System.out.println ("mid: " + mid);
				if (a[mid] == mid){
					//left = mid+1;
					left = mid+1;
					
					System.out.println ("new left: " + left);
					System.out.println ("new right: " + right);
					System.out.println ("---------------------------");
				}
				else{
					right = mid;
					System.out.println ("new left: " + left);
					System.out.println ("new right: " + right);
					System.out.println ("---------------------------");
				}
				
				
			}

			else{
				if (a[left] != left)
					System.out.println ("missing: " + left);
				else if (a[right] != right)
					System.out.println ("missing: " + right);
				else
					System.out.println ("No number is missing");
				break;
			}

		}
	}
	
	public static void main(String[] args) {
		Test1.call();



	}
}
