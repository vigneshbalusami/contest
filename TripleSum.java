package com;
import java.util.Scanner; 

public class TripleSum {
	static int[] fact = new int[100010];
	
	public static int getTwo(int first,int second,int c1,int c2){
		int total,ans=0;
		total = first*2+second;
		if(total%second==0&&total%first!=0){
			ans += findCom(c1,2)*c2*6; 
		}
		ans =0;
		total = second*2+first;
		if(total%first==0&&total%second!=0){
			ans +=findCom(c2,2)*c1*6;
		}
		return ans;
	}
	public static int getThree(int first,int c1,int second,int c2,int third,int c3){
		int sum = first+second+third;
		int value = 0;
		if(sum%first==0){
			value += 1;
		}
		if(sum%second==0){
			value += 1;
		}
		if(sum%third==0){
			value += 1;
		}
		if(value==1)
			return c1*c2*6;
		else
			return 0;
	}
	public static int fac(int n){
		if(n<2){
		return 1;
		}else if(fact[n]!=0){
			return fact[n];
		}else {
			fact[n] = n*fac(n-1);
			return fact[n];
		}
	}
	public static int getPosition(int arr[],int n,int value){
		for(int i=0;i<n;i++){
			if(arr[i]==value)
				return i;
		}
		return -1;
	}

	public static int findCom(int n,int m){
		return fac(n)/fac(m)*fac(n-m);
	}
	public static void main(String str[]){
		int n,i,j,k,value,ans=0,count=0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int arr[] = new int[103],h[] = new int[103];
		for(i=0;i<n;i++){
			value = sc.nextInt();
			int pos = getPosition(arr,count,value);
			if(pos==-1){
				arr[count]=value;
				h[count++]=1;
			}else{
				h[pos]++;
			}
		
		}
		for(i=0;i<count;i++){
			for(j=i+1;j<count;j++){
				if(!(h[i]==1&&h[j]==1)){
					ans +=getTwo(arr[i],h[i],arr[j],h[j]);
				}
				for(k=j+1;k<count;k++){
					ans += getThree(arr[i],h[i],arr[j],h[j],arr[k],h[k]);
				}
			}
		}
		System.out.print(ans);
	}
	
} 

/*
20
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
*/



/*

#include <stdio.h>

int fact[100001];

int factorial(int n) {
if(n < 2) {
    return 1;
} else if(fact[n] !=0) {
    return fact[n];
} else {
    fact[n] = n * factorial(n-1);
    return fact[n];
}
}

int findComb(int n,int r){
return factorial(n)/factorial(r) * factorial(n-r);
}

int checkWithTwo(int a,int b,int aCount, int bCount) {
int total = a*2+b,ans = 0;
if(total%b==0 && total%a!=0) {
    ans = findComb(aCount,2) * bCount * 6;
}
total = b*2+a,ans = 0;
if(total%a==0 && total%b!=0) {
    ans += findComb(bCount,2) * aCount * 6;
}
return ans;
}

int checkWithThree(int a,int aCount,int b,int bCount,int c,int cCount) {
int sum = a+b+c;
int value = (sum%a == 0) + (sum%b == 0) + (sum%c == 0);
return value == 1 ? aCount*bCount*cCount*6 : 0;
}

int findPos(int arr[110], int n,int ele) {
for(int i=0;i<n;i++) {
    if(arr[i] == ele) 
        return i;
}
return -1;
}

int main(void) {
long int n,i;
scanf("%ld",&n); 
int ele,arr[110],re[110],j,k,co=0,ans=0;
for(i=0;i<n;i++) {
    scanf("%d",&ele);
    int pos = findPos(arr,co,ele);
    if(pos == -1) {
        arr[co] = ele;
        re[co++] = 1;
    } else {
        re[pos]++;
    }
}

for(i=0;i<co;i++) {
    for(j=i+1;j<co;j++) {
        if(!re[i]==1&&re[j]==1)
        ans += checkWithTwo(arr[i],re[i],arr[j],re[j]);
        for(k=j+1;k<co;k++) {
            ans += checkWithThree(arr[i],re[i],arr[j],re[j],arr[k],re[k]);
        }
    }
}
printf("%d",ans);
return 0;
}
*/