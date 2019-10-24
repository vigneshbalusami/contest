package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ShortestCyclicPath {
	private static Map<String,Integer> weight = new HashMap<>(); 
	private static Set<Integer> whiteSet = new HashSet<>();
	private static Set<Integer> whSet = new HashSet<>();
	private static Set<Integer> blackSet = new HashSet<>();
	//private static Set<Integer> greySet = new HashSet<>();
	//private static Map<Integer,Integer> dfsMap = new HashMap<>(); 
	private static List<List<Integer>> path = new ArrayList<>();
	private static int count = 0,wtg = 0;
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),m = sc.nextInt(),i;
		count = 999999999;
		for(i = 0; i <= n; i++){
			path.add(new ArrayList<>());
		}
		i = 0;
		while(m>0){
			int u = sc.nextInt(), v = sc.nextInt(),h = sc.nextInt(), t = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			if(path.get(u).size()>0){
				list = path.get(u);
			}
			whiteSet.add(u);
			whiteSet.add(v);
			list.add(v);
			path.set(u, list);
			if(weight.get(u+"+"+v)!=null){
				int tst = weight.get(u+"+"+v);
				if(t-h>tst){
					weight.put(u+"+"+v,t-h);
				}
			}else{
				weight.put(u+"+"+v,t-h);
			}
			m--;
		}
		findLoopInDFS();
		System.out.println(count+" "+wtg);
	}
	
	public static void findLoopInDFS(){
		int i,j,k,vertex,flag=0;
		whSet.addAll(whiteSet);
		while(whSet.size()>0&&flag!=1){
			Iterator<Integer> itr =  whSet.iterator();
			vertex = itr.next();
			flag=1;
			traverseDFS(vertex,-1,new HashSet<>(),new HashMap<>(),whSet,blackSet);
		}
	}
	public static void traverseDFS(int vertex,int previousVertex, Set<Integer> greySet, Map<Integer,Integer> dfsMap,Set<Integer> whiteSet,Set<Integer> blackSet){
		 if(greySet.contains(vertex)){
			int c = 1,w=0,v=vertex;
			w = w + weight.get(previousVertex+"+"+v);
			while(dfsMap.get(previousVertex)!=-1&&previousVertex!=vertex){
			//	System.out.print(previousVertex+"->");
				v = previousVertex;
				previousVertex = dfsMap.get(previousVertex);
				w = w + weight.get(previousVertex+"+"+v);
			c++;	
			}
			if(count>c&&w>0){
				count = c;
				wtg = w;
			}
			if(count==c){
				wtg = wtg<w?w:wtg;
			}
		//	System.out.println();
		}
		else if(!blackSet.contains(vertex)&&whiteSet.contains(vertex)){
			 Set<Integer> wSet = new HashSet<>();
			 wSet.addAll(whiteSet);
			 wSet.remove(vertex);
			 Set<Integer> bSet = new HashSet<>();
			 bSet.addAll(blackSet);
			Set<Integer> gSet = new HashSet<>();
			gSet.addAll(greySet);
			gSet.add(vertex);
			 Map<Integer,Integer> dMap = new HashMap<>(); 
			 dMap.putAll(dfsMap);
			 dMap.put(vertex, previousVertex);
			List<Integer> adj = path.get(vertex);
			for(int i = 0; i < adj.size(); i++){	
				traverseDFS(adj.get(i),vertex,gSet,dMap,wSet,bSet);
			}
			whSet.remove(vertex);
			greySet.remove(vertex);
			bSet.add(vertex);
		}
	}
}

/*
11 16
1 3 2 4
3 4 3 6
4 5 2 4
5 6 2 4
6 4 2 4
6 7 2 4
7 5 2 4
1 2 2 4
2 8 3 6
8 9 2 4
9 2 1 2
8 10 6 12
9 10 5 10
10 11 3 8
11 10 3 6
10 11 3 6

*/

/*
 
 9 12
1 8 3  6
1 7 3 6
8 7 2 4
7 1 2 4
1 2 2 4
2 4 4 2
4 3 4 2
3 5 3 2
5 6 3 6
6 1 3 2
7 9 2 8
9 1 2 4
*/



/*
12 19
1 8 2 3
1 2 2 4
8 3 3 6
8 4 5 6
2 11 2 3
2 12 6 3
3 5 8 9
3 6 34 34
4 6 2 4
7 4 3 4
11 7 4 5
5 9 2 3
6 9 3 4
6 10 6 9
7 6 19 10
7 12 4 5
9 10 8 9
10 7 4 8
11 4 2 13
*/