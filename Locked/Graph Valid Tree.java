/**
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree? Show More Hint Note: 
you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
**/

public class Solution {
    public boolean validTree(int n, int[][] edges) {
    	int numOfComponent = n;
    	int[] component = new int[n];
    	for (int i = 0; i < n; i++) component[i] = i;
    	for (int[] edge : edges) {
    		if (union(edge, component)) {
    			numOfComponent--;
    		}	
    		else return false;
    	}
    	return numOfComponent == 1;
    }
    private boolean union(int[] edge, int[] component) {
    	int index1 = find(edge[0], component);
    	int index2 = find(edge[1], component);
    	if (index1 == index2) return false;
    	component[index1] = index2;
    	return true;
    }
    private int find(int i, int[] arr) {
    	if (arr[i] == i) return i;
    	return find(arr[i], arr);
    }
}
