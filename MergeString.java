package com;

import java.util.Scanner;

public class MergeString {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0){
			String firstStr = sc.next(),secondStr = sc.next();
			char first[] = firstStr.toCharArray(),second[] = secondStr.toCharArray();
			int i = 0,j = 0,count=0,c=0,l;
			int k = 0,l1=firstStr.length(),l2=secondStr.length();
			char revFirst[] = new char[l1],revSecond[] = new char[l2];
			int subarr[] = new int[l2],revSubarr[] = new int[l2];
			j = l1-1;
			k = l2-1;
			for(i=0;i<l1||i<l2;i++){
				if(j>=0){
					revFirst[i] =  first[j];
					j--;
				}
				if(k>=0){
					revSecond[i] =  second[k];
					k--;
				}
			}
			subarr[0] = 0;
			for(i=0,j=l2-1;i<l1&&j>=0;){
				if(first[i]==second[0]&&first[l1-1]==second[j]){
					if((l1-1)-i==j){
						c=1;
						for(k=i+1,l=1;k<l1&&l<=j;){
							if(first[k]==second[l]){
								c++;
								k++;l++;
							}
							else{
								c = 0;
								i++;j--;
								break;
							}
						}
						if(count<c){
							count = c;
							break;
						}else if(c!=0)
							break;
					}else{
						if(l1-i>j)
							i++;
						else
							j--;
					}
				}
				else if(first[i]!=second[0]){
					i++;
				}
				else if(first[l1-1]!=second[j]){
					j--;
				}
			}
			
			for(i=0,j=l2-1;i<l1&&j>=0;){
				if(first[i]==revSecond[0]&&first[l1-1]==revSecond[j]){
					if((l1-1)-i==j){
						c=1;
						for(k=i+1,l=1;k<l1&&l<=j;){
							if(first[k]==revSecond[l]){
								c++;
								k++;l++;
							}
							else{
								c = 0;
								i++;j--;
								break;
							}
						}
						if(count<c){
							count = c;
							break;
						}else if(c!=0)
							break;
					}else{
						if(l1-i>j)
							i++;
						else
							j--;
					}
				}
				else if(first[i]!=revSecond[0]){
					i++;
				}
				else if(first[l1-1]!=revSecond[j]){
					j--;
				}
			}
			
			for(i=0,j=l2-1;i<l1&&j>=0;){
				if(revFirst[i]==second[0]&&revFirst[l1-1]==second[j]){
					if((l1-1)-i==j){
						c=1;
						for(k=i+1,l=1;k<l1&&l<=j;){
							if(revFirst[k]==second[l]){
								c++;
								k++;l++;
							}
							else{
								c = 0;
								i++;j--;
								break;
							}
						}
						if(count<c){
							count = c;
							break;
						}else if(c!=0)
							break;
					}else{
						if(l1-i>j)
							i++;
						else
							j--;
					}
				}
				else if(revFirst[i]!=second[0]){
					i++;
				}
				else if(revFirst[l1-1]!=second[j]){
					j--;
				}
			}
			
			System.out.println((l1+l2)-count);
			t--;
		}
	}
}






/*
ababc
bcabc
cdefg
abgfe

*/