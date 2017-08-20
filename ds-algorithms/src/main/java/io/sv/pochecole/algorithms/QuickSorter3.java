package io.sv.pochecole.algorithms;

import java.util.Arrays;

public class QuickSorter3 {

	QuickSorter3(){

	}

	private int partition(int a[], int low, int high){

		int pivot = a[high];
		
		int start=low; int end=high;

		int temp;

		while (start < end){

			while (start< high && a[start] <= pivot){
				start ++;
			}
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
		
		a[high] = a[start];
		a[start] = pivot;		
		return start; //This should be the pivot 
	
	}

	private void quickSort(int a[], int start, int end){
		// pIndex is a pointer which holds the index of the "pivot". All the items less than "pivot" are to the left of the pivot.
		// And all the items that are greater than the "pivot" are to the right of the pivot.

		if (end-start <=0){
			return;
		}
		else{

			int pIndex = partition(a, start, end);

			quickSort(a, start, pIndex-1);			
			quickSort(a, pIndex+1, end);			
		}
	}

	public static void main(String[] args) {

		QuickSorter3 quickSort = new QuickSorter3();

		//int []a= {150,30,20,44,100,700,11,22,33,0,0,0,0,-100,-100,200,72,62,52}; 
		//int []a = {10,5,30,20,20,20,20,25,49,60,20,23,33,43};
		int []a = {5000,-20,87,50,0,0,0,0,0,-100,-100,-100,25,32,90,42,250,500,230,450,1000,1000,-10000,30,30,65,45,20,10};
		quickSort.quickSort(a, 0, a.length-1);

		System.out.println("Sorted Array: " + Arrays.toString(a));
	}

}
