package com.enjoyingpeter.training.algorithm.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * BFS 탐색 예제,
 * Adjancency Matrix를 만든후, 해당 매트릭스를 이용하여 BFS를 찾는다.
 */
public class Practice1 {
	/**
	 * Matrix는 int[row][col] 이라고 하였을때,
	 * row가 현재 정점이고, col은 이동할수 있는 정점을 의미함.
	 * - int[x][x]은 제자리이기 때문에 이동 불가
	 * - int[x][y]은 정점 y로 이동이 가능하다면 값을 1로 설정
	 */
	private int[][] adjacencyMatrix = { {0, 1, 1, 0, 0, 0},
										{1, 0, 0, 1, 1, 0},
										{1, 0, 0, 1, 0, 1},
										{0, 1, 1, 0, 1, 1},
										{0, 1, 0, 1, 0, 1},
										{0, 0, 1, 1, 1, 0} };

	private Queue<Integer> searchQueue = new LinkedList<>();
	private Set<Integer> visited = new HashSet<>();


	public static void main(String[] args) {
		Practice1 practice1 = new Practice1();

		/**
		 * 0에서 검색을 시작하고,
		 * 0은 이미 시작시에 방문을 하기때문에 초기값을 설정함
		 */
		practice1.searchQueue.offer(0);
		practice1.visited.add(0);

		while(practice1.searchQueue.size() > 0) {
			practice1.BFS();
		}

		System.out.println("BFS 탐색 종료");
	}

	void BFS() {
		int i = searchQueue.poll();

		for (int idx = 0; idx < adjacencyMatrix.length ; idx++) {
			if (adjacencyMatrix[i][idx] == 1 && adjacencyMatrix[idx][i] == 1) {
				if (!visited.contains(idx)) {
					System.out.println((i + 1) + " 에서 " + (idx + 1) + "을 방문함 ");
					/**
					 * 방문하는 지점에 대해서는 방문큐를 추가하고,
					 * 방문 flag를 설정함
					 */
					searchQueue.add(idx);
					visited.add(idx);
				}
			}
		}
	}
}
