package com.treeLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(),i=0,max=0,j=0;
		int arr[] = new int[n];
		for(i=0;i<n;i++){
			arr[i] = sc.nextInt();
			if(max<arr[i])
				max = arr[i];
		}
		int treeIndex[] = new int[max+1];
		List<Integer> list = new ArrayList<>();
		for(i=0;i<=max;i++){
			treeIndex[i]=1;
		}
		for(i=0;i<n;i++){
			list.add(arr[i]);
			for(j=arr[i]+1;(j<=max)&&(j+1<=max)&&(treeIndex[j]==treeIndex[j+1]);j++){
				treeIndex[j]=treeIndex[j]+1;
			}
			if(j<=max&&!list.contains(j)){
				treeIndex[j]=treeIndex[j]+1;
			}
			for(j=arr[i]-1;(j>0)&&(j-1>=0)&&(treeIndex[j]==treeIndex[j-1]);j--){
				treeIndex[j]=treeIndex[j]+1;
			}
			if(j>=0&&!list.contains(j)){
				treeIndex[j]=treeIndex[j]+1;
			}
		}
		for(i=0;i<n;i++){
			System.out.print(treeIndex[arr[i]]+",");
		}
	}
}
