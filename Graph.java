package com.tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Graph {
	public static int index = 0;
	public static int nodeLevel = 0;
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(),i=0;
		while(i<t){
			int n = sc.nextInt(),start;
			Map<Integer,List<Integer>> graph = new HashMap<>();
			List<Integer> nodes = new ArrayList<>();
			for(int j = 0; j < n-1; j++){
				int source = sc.nextInt(),destination = sc.nextInt();
				if(graph.containsKey(source)){
					nodes = graph.get(source);
				}
				else{
					nodes = new ArrayList<>();
				}
				if(!nodes.contains(destination)){
					nodes.add(destination);
					
					}
				
				graph.put(source,nodes);
			}
			start = sc.nextInt();
			nodeLevel = 0;
			index = 0;
			List<Integer> visited = new ArrayList<>();
			findDimmest(graph,start,visited,1);
			System.out.println(index);
			i++;
		}
	}
	public static void findDimmest(Map<Integer,List<Integer>> graph,int start,List<Integer> visited,int level){
		if(!visited.contains(start)){
			visited.add(start);
			if(nodeLevel<level){
				nodeLevel = level;
				index = start;
			}
			else if(nodeLevel==level){
				if(index>start)
					index = start;
			}
			if(graph.containsKey(start)){
				for(int i = 0;i<graph.get(start).size();i++){
					findDimmest(graph,graph.get(start).get(i),visited,level+1);
				}
			}
		}
	}
}
