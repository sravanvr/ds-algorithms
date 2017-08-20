package io.sv.pochecole.algorithms;

import java.util.Arrays;

/***
 * 
 * Quick Sort implementation using left and right pointer approach. We use "right most" element as pivot in this example.
 * The location (left most or right most) from where you have selected the pivot is import to determine what 
 * should be your pivot's final location.
 * If the initial pivot location is "left most" then the final position of the pivot should be the index pointed by "right" pointer.
 * If the initial pivot location is "right most" then the final position of the pivot should be the index pointed by "left" pointer. 
 *  
 *
 */
public class QuickSorter {

	QuickSorter(){

	}

	private int partition(int a[], int low, int high){

		int pivot = a[low];
		
		int start=low; int end=high;

		int temp;

		while (start < end){
			
			// while loop-1
			while (start < high && a[start] <= pivot){
				start ++;
			}
			// while loop-2
			while (end>0 && a[end] > pivot ){				
				end --;
			}
			
			if (start < end){
				temp = a[start];
				a[start] = a[end];
				a[end] = temp;
			}
		}

		// By this time (i.e. when both pointers have met), we would have swapped right pointer elements and left pointer elements, 
		// in such a way that numbers to the left of the "mid meeting point" are smaller and to the right they are larger. 

		// This is CORRECT swapping.
		a[low] = a[end];
		a[end] = pivot;
		return end; //This should be the pivot 
		
		/*
		// BELOW is WRONG swapping.If you look at "while loop-1" above, it would have stopped when "a[start]>pivot". That means
		   when both left and right pointers eventually meet, left pointer always points a number that is larger than pivot.  
		// In other words, when "end" pointer meets the "start" pointer and eventually crosses it one step, it ends up
		// pointing to (It MUST point) an element that is smaller than the pivot.
 		// With that explanation, if you look at below code, what we are trying to do is, swap the "BIGGER" element (wrt pivot) pointed
 		// by the left pointer with the "first" element pointed by "low". Which is clearly a blunder because BIGGER element should go to 
		   right and not to the left.  
 		 
		a[low] = a[start];
		a[start] = pivot;
		return start; //This should be the pivot
	*/
	}

	private void quickSort(int a[], int start, int end){
		// pIndex is a pointer which holds the index of the "pivot". All the items less than "pivot" are to the left of the pivot.
		// And all the items that are greater than the "pivot" are to the right of the pivot.

		if (end-start <0){
			return;
		}
		else{

			int pIndex = partition(a, start, end);

			quickSort(a, start, pIndex-1);			
			quickSort(a, pIndex+1, end);			
		}
	}

	public static void main(String[] args) {

		QuickSorter quickSort = new QuickSorter();

		int []a= {150,30,20,44,100,700,11,22,33,0,0,0,0,-100,-100,200,72,62,52}; 
		//int []a = {10,5,30,20,20,20,20,25,49,60,20,23,33,43};
		//int []a = {5000,-20,87,50,0,0,0,0,0,-100,-100,-100,25,32,90,42,250,500,230,450,1000,1000,-10000,30,30,65,45,20,10};

		quickSort.quickSort(a, 0, a.length-1);

		System.out.println("Sorted Array: " + Arrays.toString(a));
	}

}
