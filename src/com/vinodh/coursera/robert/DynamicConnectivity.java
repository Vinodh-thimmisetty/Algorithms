package com.vinodh.coursera.robert;

/**
 * Asymptotic Analysis (Efficiency of Algorithm)
 * Quick Find ::
 *	 Initialize ==> O(n)
 *	 Union		==> O(n)
 *	 Find 		==> O(1)
 * 
 * Quick Union ::
 *	 Initialize ==> O(n)
 *	 Union		==> O(n)
 *	 Find 		==> O(n)
 * 
 * Weighted Quick Union ::
 *	 Initialize ==> O(n)
 *	 Union		==> O(logn)
 *	 Find 		==> O(logn)
 *
 * Quick union with Path Compression::
 *	 Initialize ==> O(n)
 *	 Union		==> O(N+MlogN) // N unions of M objects
 *	 Find 		==> O(N+MlogN)
  * Weighted Quick union with Path Compression::
 *	 Initialize ==> O(n)
 *	 Union		==> O(N+Mlg*N)
 *	 Find 		==> O(N+Mlg*N)
 *
 * @Professor :: Robert Sedgwick
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class DynamicConnectivity {

	public static void main(String[] args) {

	System.out.println("----- Quick Find --------");	
		QuickFind quickFind = new QuickFind();
		quickFind.union(4, 3);
		quickFind.union(3, 8);
		quickFind.union(6, 5);
		quickFind.union(9, 4);
		quickFind.union(2, 1);
		quickFind.isConnected(8, 9);
		quickFind.union(5, 0);
		quickFind.union(7, 2);
		quickFind.union(6, 1);
System.out.println("-------Quick Union -----");
		QuickUnion quickUnion = new QuickUnion(); 
		quickUnion.union(4, 3);
		quickUnion.union(3, 8);
		quickUnion.union(6, 5);
		quickUnion.union(9, 4);
		quickUnion.union(2, 1);
		quickUnion.isConnected(8, 9);
		quickUnion.union(5, 0);
		quickUnion.union(7, 2);
		quickUnion.union(6, 1);
System.out.println("---------- Weighted Quick union--------");	
	}
}

class QuickFind {
	private int n = 10;
	private int[] arr = new int[n];

	public QuickFind() {
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
	}

	public boolean isConnected(int p, int q) {
		return arr[p] == arr[q];
	}

	public void union(int p, int q) {
	 // Equivalence Relation == Reflexive + Symmetric + Transitive
		if (p == q) {
			System.out.println(" both the nodes are same");
			return;
		}

		for (int i = 0; i < n; i++) {
			int pId = arr[p];
			int qId = arr[q];
			if (arr[i] == pId) {
				arr[i] = qId;
				System.out.println("Connected ::" + pId + " and " + arr[i]);
			}
		}
	}
}

class QuickUnion{
	private int n = 10;
	private int[] arr = new int[n];

	public QuickUnion() {
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
	}

	public boolean isConnected(int p, int q) {
		return root(q)==root(q);
	}

	public int root(int i){
		 while(arr[i] != i){
			  i=arr[i];
		 }
		return i;
	}
	public void union(int p, int q) {
	// p,q ==> p has parent as q
		int pId = root(p);
		int qId = root(q);
	 	 arr[pId] = qId;
	System.out.println("Connected ::" + p + " and " + q);
	}
	
}

class WeightedQuickUnion{
	private int n = 10;
	private int[] arr = new int[n];
	private int[] sizeArray = new int[n];
	public WeightedQuickUnion(){
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		
	}
	public boolean isConnected(int p, int q) {
		return root(q)==root(q);
	}

	public int root(int i){
		 while(arr[i] != i){
			 //arr[i]=arr[arr[i]]; Path Compression
			  i=arr[i];
		 }
		return i;
	}
	public int sizeOfTree(int i){
		int sz =1;
		while(arr[i] != i){
			sz++;
		}
		sizeArray[i] = sz;
		 return sizeArray[i];
	}
	
	public void union(int p, int q) {
	// p,q ==> p has parent as q
		int pId = root(p);
		int qId = root(q);
		if (pId == qId) return;
		if(sizeOfTree(p) > sizeOfTree(q)){
			arr[qId] = pId;
 			sizeArray[pId]+=sizeArray[qId];
 		}else{
			arr[pId] = qId;}
			sizeArray[qId]+=sizeArray[pId];

	}


}