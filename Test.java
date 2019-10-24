package com.tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(),i=0;
		while(i<t){
			int n = sc.nextInt(),count=0,start,end;
			Map<Integer,Integer> vehicle = new TreeMap<>();
			List<Integer> startPosition = new ArrayList<>();
			for(int j =0;j<n;j++){
				start = sc.nextInt();
				end = sc.nextInt();
				if(vehicle.containsKey(start)){
					if(vehicle.get(start)<end)
						vehicle.put(start, end);
				}else {
					vehicle.put(start, end);
				}
			}
			start = -327672;
			end = -327672;
			for(Map.Entry<Integer, Integer> entry : vehicle.entrySet()){
				
					if(entry.getKey()<end){
						if(!(entry.getValue()<=end)){
							count = count + Math.abs(entry.getValue()-end);
						}
					}else{
						count = count + Math.abs(entry.getKey()-entry.getValue())+1;
					}
				
				start = entry.getKey();
				end = entry.getValue();
			}
			System.out.println(count);
			i++;
		}
	}
	
}
