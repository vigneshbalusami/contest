package com;

import java.util.Scanner;

public class TallestStudent {
	public static int count = 0;
	public static int index = 0;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t>0){
			int n = sc.nextInt(),value = 0,max = 0,c =0,ind=0;
			count = 0;
			for(int i =0; i < n; i++){
				value = sc.nextInt();
				if(value>=max){
					if(i!=0)
						c++;
					if(count<=c){
					count = c;
					index = ind;
					}
					ind = i;
					c = 0;
					max = value;
				}
				if(value<max){
					c++;
				}
			}
			if(count<=c){
				count = c;
				index = ind;
				}
			System.out.println(index+1);
			t--;
		}
	}
}


/*

4
5
5 4 3 1 2
6
3 2 1 5 4 1
7
3 2 1 5 4 1 2
7
5 2 1 5 4 1 2

*/