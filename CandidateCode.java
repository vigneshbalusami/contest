package com.org1;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {
    	 Scanner sc =  new Scanner(System.in);
         int t = sc.nextInt();
         while(t>0){
         	BigInteger n = sc.nextBigInteger();
         	int len = n.bitCount();
         	int arr[] = new int[len],i=0,j=0,index=0,count=0,c=0;
         	String str = "";
         	if(!n.equals(BigInteger.ZERO)){
	         	while(!n.equals(BigInteger.ZERO)){
		         	if(!n.mod(new BigInteger("2")).equals(BigInteger.ZERO)){
		         		str = "1"+str;
		         	}else{
		         		str = "0"+str;
		         	}
		         	j++;
		         	n = n.shiftRight(1);
	         	}
	         	for(i=0,j=0;i<str.length();i++){
	         		if(str.charAt(i)=='1')
	         			arr[j++] = i;
	         	}
	         	for(i = 0,index=0; i <=arr[len-1]; i++){
	         		if(str.charAt(i)=='0'){
		         		if(arr[index]<=i){
		         			index++;
		         		}
	         		}else if(arr[index]<i){
	         			index++;
	         		}
	         		for(j=index;j<len;j=j+2){
	         			if(j+1<len){
	         				count = count + Math.abs(arr[j]-arr[j+1]);
	         			}else {
	         				count = count + Math.abs(arr[j]-str.length());
	         			}
	         		}
	
	             	//System.out.print(str+" "+arr+" "+count);
	         	}
         	}
         	System.out.println(count);
         	t--;
         	/*while(!n.equals(0)){
         		
         		
         	}*/
         }
    }
  
}