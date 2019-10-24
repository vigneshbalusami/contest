package com.subarray;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class solution {
	public static char[] doubleValue = new char[64];
	public static Map<Character,Integer> mapValue = new HashMap<>();
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		setDoubleValue();
		while(t>0){
			int n = sc.nextInt(),value=0,temp=0,value2=0,i=0,j=0,count=0;
			String str = sc.next();
			char arr[] = str.toCharArray();
			int sum[] = new int[n];
			int doubleSum[] = new int[n];

			for(i=n-1,j=0;i>=0;i--,j++){
				 value = mapValue.get(arr[i]);
				// System.out.print(doubleValue[value]);
				 if(j%2==0)
				 value = value*2;
				 value2 = value/64 + value%64;	
				// System.out.print(doubleValue[value2]);
				 count = count + value2;
			//	 System.out.print(" "+count);
			} 
			value = count/64;
			System.out.println(doubleValue[(64-(count-64*value))%64]);
			/*for(i=0;i<n;i++){
				System.out.print(doubleSum[i]+" ");
			}*/
			t--;
		}
	}
	public static void setDoubleValue(){
		int i,j=0;
		for(i = 0;i <= 25;i++){
			doubleValue[i] = (char)('A' + i);
			mapValue.put(doubleValue[i],i);
		}
		for(j=0,i=26;i <= 51;i++,j++){
			doubleValue[i] = (char)('a'+j);
			mapValue.put(doubleValue[i],i);
		}
		for(j=0,i=52;i <= 61;i++,j++){
			doubleValue[i] = (char)('0'+j);
			mapValue.put(doubleValue[i],i);
		}
		doubleValue[i++] = '+';

		mapValue.put('+',62);
		doubleValue[i++] = '/';
		mapValue.put('/',63);
	}

}
/*8
1
1
1
0
4
0000
10
1234567890
29
41201953788963824033556555672
7
3000158
11
90540677470
36
188648824429847292479287385561746664*/