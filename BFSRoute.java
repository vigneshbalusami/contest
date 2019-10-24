package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BFSRoute {
	private static List<List<Integer>> path = new ArrayList<>();
	private static List<Integer> affected = new ArrayList<>();
	private static Set<Integer> neibour = new HashSet<>();
	private static List<Integer> visited = new ArrayList<>();
	private static List<Integer> visit = new ArrayList<>();
	private static int arr[][];
	private static int countMax = 999999999;
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),m = sc.nextInt(),k = sc.nextInt(), i=0,value=0;
		arr = new int[n+1][n+1];
		for(i=0;i<=n;i++){
			path.add(new ArrayList<>());
		}
		for(i=0;i<k;i++){
			value = sc.nextInt();
			affected.add(value);
		}
		while(m>0){
			int u = sc.nextInt(), v = sc.nextInt(),w = sc.nextInt();
			if(affected.contains(u)){
				if(!affected.contains(v)){
					neibour.add(v);
				}
			}
			if(affected.contains(v)){
				if(!affected.contains(u)){
					neibour.add(u);
				}
			}
			arr[u][v]=w;
			arr[v][u]=w;
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			if(path.get(u).size()>0){
				list1 = path.get(u);
			}
			if(path.get(v).size()>0){
				list2 = path.get(v);
			} 
			if(!list1.contains(v))
				list1.add(v);
			path.set(u, list1);
			if(!list2.contains(u))
				list2.add(u);
			path.set(v, list2);
			
			m--;
		}
		while(neibour.size()>0){
			Iterator<Integer> itr =  neibour.iterator();
			int vertex = itr.next();
			neibour.remove(vertex);
		 DFS(vertex,0,visited);
		}
		System.out.println(countMax);
	}
	public static void DFS(int start,int count,List<Integer> visited1){
		if(!visited1.contains(start)){
			List<Integer> vis = new ArrayList<>();
			vis.addAll(visited1);
			vis.add(start);
			if(affected.contains(start)){
				visit.add(start);
			}
			if(affected.size()==visit.size()){
				if(countMax>count*2)
					countMax=count*2;
			}
			List<Integer> list = new ArrayList<>();
			list.addAll(path.get(start));
			for(int i = 0;i<list.size();i++){
				DFS(list.get(i),count+arr[start][list.get(i)],vis);
			}
		}
	}
}