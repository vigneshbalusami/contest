package com;

import java.util.Scanner;

public class ArrayChange {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
			int n = sc.nextInt(),m = sc.nextInt(),i,value,max=0,min=0;
			int arr[] = new int[n];
			int quries[] = new int[n+1];
			min = n+1;
			for(i =0;i<n;i++){
				arr[i]=sc.nextInt();
				quries[i] = 0;
			}
			quries[i] = 0;
			for(i =0;i<m;i++){
				value = sc.nextInt();
				if(min>value)
					min = value;
				quries[value] = 1;
			}
			max = arr[min];
			for(i =0;i<min;i++){
				System.out.print(arr[i]+" ");
			}
			for(i =min;i<n;i++){
				if(max<=arr[i]){
					if(quries[i]==1){
						max = arr[i];
					}
				}else if(max>arr[i]){
					arr[i] = 0;
				}
				System.out.print(arr[i]);

				if(i+1<n)
					System.out.print(" ");
			}
			System.out.println();
			t--;
		}
	}
}

/*
2
5 2
4 3 4 3 2
3 2 
3 1
3 2 1
2


1
14 5
5 3 2 4 2 9 6 5 1 3  10 5 2 1
5 10 2 6 0

*/