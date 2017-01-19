package com.enjoyingpeter.training.algorithm.dijkstra;

/**
 * 다익스트라 알고리즘 예제
 * 각각의 거리에 가중치가 존재하기 때문에,
 * 가중치를 가지고 최단거리가 얼마인지를 구해봄
 */
public class Practice1 {
	private int[][] adjacencyMatrix = new int[7][7];

	public static void main(String[] args) {
		Practice1 practice1 = new Practice1();
		practice1.adjacencyMatrix[1][5] = practice1.adjacencyMatrix[5][1] = 5;
		practice1.adjacencyMatrix[1][2] = practice1.adjacencyMatrix[2][1] = 2;
		practice1.adjacencyMatrix[2][5] = practice1.adjacencyMatrix[5][2] = 1;
		practice1.adjacencyMatrix[5][4] = practice1.adjacencyMatrix[4][5] = 5;
		practice1.adjacencyMatrix[4][2] = practice1.adjacencyMatrix[2][4] = 8;
		practice1.adjacencyMatrix[4][3] = practice1.adjacencyMatrix[3][4] = 1;
		practice1.adjacencyMatrix[2][3] = practice1.adjacencyMatrix[3][2] = 3;
		practice1.adjacencyMatrix[4][7] = practice1.adjacencyMatrix[7][4] = 5;
		practice1.adjacencyMatrix[3][7] = practice1.adjacencyMatrix[7][3] = 4;
		practice1.adjacencyMatrix[4][6] = practice1.adjacencyMatrix[6][4] = 1;
		practice1.adjacencyMatrix[6][7] = practice1.adjacencyMatrix[7][6] = 1;
	}
}


class Node {
	int idx;
	int distance;
}