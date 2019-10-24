package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeavyNode {
	
	public static int divisible[] = new int[1000000]; 
	public static boolean prime[] = new boolean[1000000]; 
	
	public static void findPrime(int n) 
    { 
		for(int i=0;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            if(prime[p] == true) 
            { 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
    } 
	
	public static void main(String str[]){
		
		Scanner sc = new Scanner(System.in);
		findPrime(999999);
		
		int n = sc.nextInt(), q = sc.nextInt();
		//int  pow[] = new int[n], start[] = new int[n],middle[][] = new int[n][n];
		List<Integer> pow = new ArrayList<>(),start = new ArrayList<>();
		List<List<Integer>> middle = new ArrayList<>();
		int i,j,u,v,x,y;
		for(i = 0; i < n; i++){
			List<Integer> temp = new ArrayList<>();
			temp.add(0);
			middle.set(i,temp);
			pow.add(-1);
			start.add(-1);
	      /*  middle[i][0] = 0;
	        pow[i] = -1;
	        start[i]= -1;*/
	    }
		for(i = 0; i < n-1; i++){
			u = sc.nextInt();
			v = sc.nextInt();
			start.set(v-1, u-1);
			int len = middle.get(u-1).get(0)+1;
			middle.get(u-1).set(0,len);
			middle.get(u-1).set(len, v-1);
	       /* start[v-1] = u-1;
	        int len = middle[u-1][0];
	        middle[u-1][++middle[u-1][0]] = v-1;*/
	    }
		List<Integer> spec = new ArrayList<>(),currentPow = new ArrayList<>();
		//int spec[] = new int[n],currentPow[] = new int[n];
		
		for(i = 0; i < n; i++){
			spec.set(i, sc.nextInt());
	    }
		calculatePower(n,pow,spec,start,middle,currentPow,0);
	    for(i = 0; i < q; i++){
	        j = sc.nextInt();
	           if(j==1){
	            x = sc.nextInt();
	            y = sc.nextInt();
	            int t1 = checkDivisible(y);
	            int temp = t1 - currentPow.get(x-1);
	            currentPow.set(x-1, t1);
	            spec.set(x-1, y);
	            x--;
	            if(temp !=0) {
	                while(x !=-1) {
	                    pow.set(x, pow.get(x)+temp);
	                    x = start.get(x);
	                }
	            }
	           }else if(j==2){
	        	   x = sc.nextInt();
	        	   System.out.println(pow.get(x-1));
	           }
	        }
	    }
	
	//public static int calculatePower(int n,int arr1[],int arr2[],int arr3[],int arr4[][],int arr5[],int cur) {
	public static int calculatePower(int n,List<Integer> arr1,List<Integer> arr2,List<Integer> arr3,List<List<Integer>> arr4,List<Integer> arr5,int cur) {
		  if(arr1.get(cur) == -1) {
	        int len = arr4.get(cur).get(0),sum = 0;
	        for(int i=1;i<=len;i++) {
	            sum += calculatePower(n,arr1,arr2,arr3,arr4,arr5,arr4.get(cur).get(i));
	        }
	        arr5.set(cur, checkDivisible(arr2.get(cur)));//[cur] = checkDivisible(arr2[cur]);
	        arr1.set(cur, arr5.get(cur)+sum);
	       // arr1[cur] = arr5[cur] + sum;
	        return arr1.get(cur);
	    } else {
	        return arr1.get(cur);
	    }
	}
	
	public static int checkDivisible(int value){
	    if(divisible[value] == 0) {
	        int sum = 0,l=(int) Math.sqrt(value),i=0,temp=0;
	        if(!prime[value]){
		        for(i=2;i<=l;i++) {
		        	temp = value/i;
		            if(value%i == 0) {
		                if (i==temp) 
		                    sum += i; 
		                else
		                    sum += (i + temp); 
		            }
		        }
	        }
	        sum=sum+value+1;
	        if(sum%3==0) {
	            divisible[value] = 1;
	        } else {
	            divisible[value] = -1;
	        }
	    }
	    if(divisible[value]==-1){
	        return 0;
	    } else {
	        return divisible[value];
	    }
	}
	
}


/*
 
5 5 
1 2
1 3
3 4 
3 5
16 8 17 3 18
2 1 
2 3
1 3 7
2 1 
2 3
 
 
 */

