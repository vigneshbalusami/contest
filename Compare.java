package com.treeLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Compare {
	public static void main(String args[]) throws NumberFormatException, IOException{
		Scanner sc = new Scanner(System.in);
	//	BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	//	int t = Integer.parseInt(buff.readLine());
		int t = sc.nextInt();
		while(t>0){
			int n = sc.nextInt(),diff = sc.nextInt();
			int problem[] = new int[n];
			int factor[] = new int[n];
			int maxP = 0, maxF = 0, flag = 0,count=0;
			for(int i = 0; i<n; i++){
				problem[i] = sc.nextInt();
				factor[i] = sc.nextInt();
				if(maxF<factor[i]){
					maxF = factor[i];
					maxP = problem[i];
				}
				else if(maxF==factor[i]){
					flag = 1;
					if(maxP<problem[i])
						maxP = problem[i];
				}
			}
			if(flag==1){
				for(int i = 0; i<n; i++){
					if(maxF==factor[i]&&Math.abs(maxP-problem[i])<diff){
						count = count + maxF;
					}
				}
			}else{
				count = maxF;
			}
			System.out.println(count);
		}
			t--;
		}
	}
