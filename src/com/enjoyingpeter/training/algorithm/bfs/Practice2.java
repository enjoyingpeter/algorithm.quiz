package com.enjoyingpeter.training.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 미로 탐색 예제,
 * 큐에 탐색된 장소를 쌓아두고, 해당 탐색된 곳의 길이를 측정
 */
public class Practice2 {
	/**
	 * Matrix는 int[row][col] 이라고 하였을때,
	 * row가 현재 정점이고, col은 이동할수 있는 정점을 의미함.
	 * - int[x][x]은 제자리이기 때문에 이동 불가
	 * - int[x][y]은 정점 y로 이동이 가능하다면 값을 1로 설정
	 */
	private int[][] adjacencyMatrix = { {0, 0, 0, 0, 0, 0, 0, 0},
										{0, 1, 1, 1, 1, 1, 1, 0},
										{0, 0, 0, 1, 0, 0, 1, 0},
										{0, 1, 1, 1, 0, 1, 1, 0},
										{0, 1, 0, 0, 0, 1, 0, 0},
										{0, 1, 1, 1, 0, 1, 0, 0},
										{0, 0, 0, 1, 1, 1, 1, 0},
										{0, 0, 0, 0, 0, 0, 0, 0} };

	private Queue<Coordinates> searchQueue = new LinkedList<>();
	private int shortestDistance = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Practice2 practice2 = new Practice2();

		practice2.searchQueue.add(Coordinates.of(1, 1, 1));
		practice2.adjacencyMatrix[1][1] = 2;

		while(practice2.searchQueue.size() > 0) {
			practice2.BFS();
		}

		System.out.println("BFS 탐색이 종료되었습니다. 최단거리는 : " + practice2.shortestDistance + " 입니다. ");
	}

	void BFS() {
		Coordinates coordinates = searchQueue.poll();

		int x = coordinates.x;
		int y = coordinates.y;

		/**
		 * 최단거리 탐색
		 */
		if (x == 6 && y == 6) {
			if (shortestDistance > coordinates.distance) {
				shortestDistance = coordinates.distance;
			}
		}

		/**
		 * 왼쪽 탐색
		 */
		if (adjacencyMatrix[x - 1][y] == 1) {
			searchQueue.add(Coordinates.of(x - 1, y, coordinates.distance + 1));
			adjacencyMatrix[x - 1][y] = 2;
		}

		/**
		 * 오른쪽 탐색
		 */
		if (adjacencyMatrix[x + 1][y] == 1) {
			searchQueue.add(Coordinates.of(x + 1, y, coordinates.distance + 1));
			adjacencyMatrix[x + 1][y] = 2;
		}

		/**
		 * 아래탐색 탐색
		 */
		if (adjacencyMatrix[x][y - 1] == 1) {
			searchQueue.add(Coordinates.of(x, y - 1, coordinates.distance + 1));
			adjacencyMatrix[x][y - 1] = 2;
		}

		/**
		 * 위쪽 탐색 탐색
		 */
		if (adjacencyMatrix[x][y + 1] == 1) {
			searchQueue.add(Coordinates.of(x, y + 1, coordinates.distance + 1));
			adjacencyMatrix[x][y + 1] = 2;
		}
	}
}

class Coordinates {
	int x;
	int y;
	int distance;

	public static Coordinates of(int x, int y, int distance) {
		Coordinates coordinates = new Coordinates();
		coordinates.x = x;
		coordinates.y = y;
		coordinates.distance = distance;

		return coordinates;
	}
}
