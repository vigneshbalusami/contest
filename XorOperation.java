package com;

import java.util.Scanner;

public class XorOperation {
	public static int xor[][] = new int[16][16];
	public static int hashValue[] = new int[16];
	public static int bin[] = new int[5];
	public static int count = 0;
	public static void generateMap(){
		int i,j;
		for(i=0;i<5;i++){
			bin[i]=0;
		}

		for(i=0;i<16;i++){
			hashValue[i]=0;
			System.out.println();
			for(j=0;j<16;j++){
				//System.out.print(i+"->"+j+" "+(i^j));
				System.out.print(" "+(i^j)+" ");
				xor[i][15-(i^j)] = j;
			}
		}
	}
	public static void xorOperation(int n){
		int i,j;
		while(n>0){
			
			for(j=1;j<=4;j++){
				for(i=0;i<=15;i++){
					if(hashValue[xor[bin[j]][i]]!=0){
						hashValue[xor[bin[j]][i]]--;
						bin[j] = (bin[j]^ xor[bin[j]][i]); 
						n--;
						break;
					}
				}
			}
					}
			for(i=1;i<5;i++){
				count +=bin[i];
				//System.out.println("*"+bin[i]);
			}
	}
	public static void main(String args[]){
		int i,j;

		generateMap();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),value=0;
		for(i=0;i<n;i++){
			value = sc.nextInt();
			hashValue[value]++;
		}
		xorOperation(n);
		System.out.print(count);
	}
}
