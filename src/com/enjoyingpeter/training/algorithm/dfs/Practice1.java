package com.enjoyingpeter.training.algorithm.dfs;

/**
 * DFS 탐색 예제,
 * Adjancency Matrix를 만든후, 해당 매트릭스를 이용하여 DFS를 찾는다.
 */
public class Practice1 {
	/**
	 * Matrix는 int[row][col] 이라고 하였을때,
	 * row가 현재 정점이고, col은 이동할수 있는 정점을 의미함.
	 * - int[x][x]은 제자리이기 때문에 이동 불가
	 * - int[x][y]은 정점 y로 이동이 가능하다면 값을 1로 설정
	 */
	private int[][] adjacencyMatrix = { {0, 1, 1, 0, 0, 0, 0, 0},
										{1, 0, 0, 1, 1, 0, 0, 0},
										{1, 0, 0, 0, 0, 1, 1, 0},
										{0, 1, 0, 0, 0, 0, 0, 1},
										{0, 1, 0, 0, 0, 0, 0, 1},
										{0, 0, 1, 0, 0, 0, 0, 1},
										{0, 0, 1, 0, 0, 0, 0, 1},
										{0, 0, 0, 1, 1, 1, 1, 0}};

	/**
	 * 정점 방문에 대한 표시, 방문하였으면 1로 표시
	 */
	private int[] visited = new int[8];

	/**
	 * DFS()를 back-tracking으로 돌림
	 * @param args
	 */
	public static void main(String[] args) {
		Practice1 practice1 = new Practice1();
		practice1.DFS(0);
	}

	void DFS(int i) {
		System.out.println((i+ 1) + " 를 방문했습니다.");
		visited[i] = 1;

		for (int idx = 0; idx <= 7; idx++) {
			if (adjacencyMatrix[i][idx] == 1 && visited[idx] == 0) {
				System.out.println((i + 1) + " 에서 " + (idx + 1) + " 로 이동함");
				DFS(idx);
			} else if (adjacencyMatrix[i][idx] == 0) {
				System.out.println((i + 1) + " 에서 " + (idx + 1) + " 로 이동은 길이 없어서 할 수 없습니다.");
			} else if (adjacencyMatrix[i][idx] == 1 && visited[idx] == 1) {
				System.out.println((idx + 1) + " 는 이미 방문하여서 다시 방문할 필요가 없습니다.");
			}
		}
	}
}
