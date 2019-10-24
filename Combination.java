package com;
//Java program to print all combination of size r in an array of size n 
import java.io.*;
import java.util.Scanner; 

class Combination { 
public static int count = 0;
static void combinationUtil(int arr[], int n, int r, int index, 
								int data[], int i) 
	{ 
		if (index == r) 
		{ 
			int c=0,f=0;
			for (int j=0; j<r; j++) {
				c += data[j];
				//System.out.print(data[j]+" "); 
			}
			for (int j=0; j<r; j++) {
				if(c%data[j]==0){
					f++;
				}
			}
			if(f==1){
			//System.out.print("-> "+c); 
			count++;
			}
		//	System.out.println(""); 
		return; 
		} 

		if (i >= n) 
		return; 

		data[index] = arr[i]; 
		combinationUtil(arr, n, r, index+1, data, i+1); 

		combinationUtil(arr, n, r, index, data, i+1); 
	} 

	static void printCombination(int arr[], int n, int r) 
	{ 
		int data[]=new int[r]; 

		// Print all combination using temprary array 'data[]' 
		combinationUtil(arr, n, r, 0, data, 0); 
	} 

	/*Driver function to check for above function*/
	public static void main (String[] args) { 
		int n,i,j,k,value,ans=0,count=0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int arr[] = new int[n],h[] = new int[103];
		for(i=0;i<n;i++){
			value = sc.nextInt();
			arr[i] = value;
		}
		//int arr[] = {1,2,3,4,5,67,4,4,39,33,3,9,49,4,83,45,98,34,53,45};
		//for(int i)
		//{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; 
		printCombination(arr, n, 3); 
		System.out.print(count*6); 
		
	} 
} 

