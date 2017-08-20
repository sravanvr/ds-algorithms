package io.sv.pochecole.algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        // Complete this function
        int [] result = new int[2];
        int aScore = 0;
        int bScore = 0;
            
        	if (a0>=1 && a0<=100 && b0>=1 && b0<=100){
        	if  (a0 > b0)
            	aScore++;
            else if (a0 < b0)
            	bScore++;
        	}
            	
        	if (a1>=1 && a1<=100 && b1>=1 && b1<=100){
        	if  (a1 > b1)
            	aScore++;
            else if (a1 < b1)
            	bScore++;
        	}
        	
        	if (a2>=1 && a2<=100 && b2>=1 && b2<=100){
        	if (a2 > b2)
            	aScore++;
            else if (a2 < b2)
            	bScore++;
        	}
        	
        	result[0] = aScore;
        	result[1] = bScore;
        	
     return result;           
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(a0, a1, a2, b0, b1, b2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        

    }
}

