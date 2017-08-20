package io.sv.pochecole.algorithms;

import java.util.Arrays;

/***
 * This program demonstrates using "Single pointer" implementation.
 * Note that QuickSorter1,QuickSorter2 and QuickSorter3 programs implements "Two (left and right) Pointer" implementation to make the 
 * Partition. 
 *  
 * 
 */
public class QuickSorter4 {

	private static void swap(int []a, int i, int j){
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private static int partition(int a[], int left, int right){

		// "i" is Left Order Keeper; It is responsible for maintaining the sorted order of elements that are lesser or equal than Pivot.
		// At any given point, elements of the sub array beginning from left bound (pointed by "left" index) until the element pointed 
		// by "i" are ALWAYS <= Pivot. 
		
		int i = left-1; // Left order keeper.
		int pivot = a[right];	// Choose right most as pivot
		for (int j=left; j< right; j++ ){	//"j" tracks elements from left bound to right bound.
			if (a[j] <= pivot)	// If the element tracked by "j" is <= then increase "i" and swap a[j] with a[i]
				swap(a,++i,j);			
		}

		swap(a,i+1,right);	// Remember "i+1" always points to an element LARGER than pivot. This is where pivot should be shifted to. 

		return (i+1);

	}
	
	
	private static void quickSort(int a[], int left, int right){

		if (left < right){
			int pivot = partition(a, left, right);
			quickSort(a, left, pivot-1);
			quickSort(a, pivot+1, right);
		}
	}
	public static void main(String[] args) {
		int []a =  {5000,-20,87,50,0,0,0,0,0,-100,-100,-100,25,32,90,42,250,500,230,450,1000,1000,-10000,30,30,65,45,20,10};
		int n = a.length;

		QuickSorter4.quickSort(a, 0, n-1);

		System.out.println("Sorted Array: " + Arrays.toString(a));
	}
}
