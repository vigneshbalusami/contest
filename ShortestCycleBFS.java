
package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ShortestCycleBFS {
	private static Map<String,Integer> weight = new HashMap<>(); 
	private static Set<Integer> whiteSet = new HashSet<>();
	private static Set<Integer> blackSet = new HashSet<>();
	private static List<List<Integer>> path = new ArrayList<>();
	private static List<Integer> queue = new ArrayList<>();
	private static List<List<List<Integer>>> test = new ArrayList<>();
	private static int count = 0,wtg = 0;
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),m = sc.nextInt(),i;
		count = 999999999;
		for(i = 0; i <= n; i++){
			path.add(new ArrayList<>());
			List<List<Integer>> t2 = new ArrayList<>();
			test.add(t2);
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
		while(whiteSet.size()>0){
			Iterator<Integer> itr =  whiteSet.iterator();
			int vertex = itr.next();
			whiteSet.remove(vertex);
			List<List<Integer>> t2 = new ArrayList<>();
			List<Integer> t = new ArrayList<>();
			t.add(vertex);
			t2.add(t);
			test.add(vertex,t2);
			queue.add(vertex);
			BFS();
		}
		System.out.println(count+" "+wtg);
	}
	public static void BFS(){
		while(queue.size()>0){
			int vertex = queue.get(0),i,j;
			queue.remove(0);
			List<List<Integer>> t = test.get(vertex);
			
			if(!blackSet.contains(vertex)){
			blackSet.add(vertex);
					
					for( i = 0 ;i<path.get(vertex).size();i++){
						if(!queue.contains(path.get(vertex).get(i))){
							queue.add(path.get(vertex).get(i));
						}
						whiteSet.remove(path.get(vertex).get(i));
						for(j=0;j<t.size();j++){
						List<Integer> tempList = new ArrayList<>();
						tempList.addAll(t.get(j));
						if(tempList.contains(path.get(vertex).get(i))){
							int c =0,c1=path.get(vertex).get(i),f=0,c3=1;
							for(int k=0;k<tempList.size();k++){
								if(f==1){
									c=c+weight.get(c1+"+"+tempList.get(k));
									c3++;
								}
								c1=tempList.get(k);
								if(tempList.get(k)==path.get(vertex).get(i)){
									f=1;
								}
							}
							c=c+weight.get(c1+"+"+path.get(vertex).get(i));
							if(count>c3&&c>0){
								count=c3;
								wtg = c;
							}
							if(count==c3){
								if(wtg>c)
									wtg = c;
							}
								
						}else{
						tempList.add(path.get(vertex).get(i));
						List<List<Integer>> t2 = test.get(path.get(vertex).get(i));
						t2.add(tempList);
						test.set(path.get(vertex).get(i), t2);
						}
					}
				}
			}else{
				for( i = 0 ;i<path.get(vertex).size();i++){
					if(!queue.contains(path.get(vertex).get(i))){
						queue.add(path.get(vertex).get(i));
					}
				for(j=0;j<t.size();j++){
				List<Integer> tempList = new ArrayList<>();
				tempList.addAll(t.get(j));
				if(tempList.contains(path.get(vertex).get(i))){
					int c =0,c1=path.get(vertex).get(i),f=0,c3=1;
					for(int k=0;k<tempList.size();k++){
						if(f==1){
							c=c+weight.get(c1+"+"+tempList.get(k));
							c3++;
						}
						c1=tempList.get(k);
						if(tempList.get(k)==path.get(vertex).get(i)){
							f=1;
						}
					}
					c=c+weight.get(c1+"+"+path.get(vertex).get(i));
					if(count>c3&&c>0){
						count=c3;
						wtg = c;
					}
					if(count==c3){
						if(wtg>c)
							wtg = c;
					}
				}
			}
			
			}
			}
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

/*
6 10
1 2 2 3
2 3 3 4
3 1 3 4
3 4 3 5
4 1 2 6
1 3 3 6
4 5 4 5
5 1 4 6
1 6 3 4
6 5 3 5


*/