package com.enjoyingpeter.training.algorithm.dfs;

public class Practice2 {
	/**
	 * 처음 최단거리 초기값은 정수 최대값으로 지정
	 */
	int minLength = Integer.MAX_VALUE;

	private int[][] mazeMatrix = { {0, 0, 0, 0, 0, 0, 0},
									{0, 1, 1, 1, 1, 1, 0},
									{0, 0, 0, 0, 0, 1, 0},
									{0, 1, 1, 1, 1, 1, 0},
									{0, 1, 0, 1, 0, 0, 0},
									{0, 1, 1, 1, 1, 1, 0},
									{0, 0, 0, 0, 0, 0, 0} };

	public static void main(String[] args) {
		Practice2 practice2 = new Practice2();
		practice2.DFS(1, 1, 1);

		System.out.println("최단거리는 : " + practice2.minLength);
	}

	void DFS(int x, int y, int length) {
		if (x == 5 && y == 5) {
			System.out.println("미로의 도착지점에 도착하였습니다.");

			if (minLength > length) {
				System.out.println("현재 최단거리 " + minLength + " 보다 " + length + " 가 적기 때문에 최단거리를 갱신합니다.");
				this.minLength = length;
			} else {
				System.out.println("현재 최단거리 " + minLength + " 보다 " + length + " 가 크기 때문에 최단거리를 갱신하지 않습니다.");
			}
		} else {
			/**
			 * 방문한 지점은 2로 표시
			 */
			mazeMatrix[x][y] = 2;

			/**
			 * 좌, 우, 상, 하로 모두 탐색하여
			 * 해당 길로 탐색한 적이 없거나 길이 있으면 그쪽으로 이동
			 */

			/**
			 * 왼쪽 길이 존재하면 왼쪽길 탐색, 왼쪽길 탐색이 모두 끝난 이후에 오른쪽 길을 탐색
			 */
			if (mazeMatrix[x-1][y] == 1) {
				System.out.println(x + "," + y + " 에서 " + (x - 1) + "," + y + "로 이동");
				DFS(x-1, y, length + 1);
			}

			/**
			 * 오른쪽 길이 존재하면 오른쪽 길 탐색, 오른쪽 길을 탐색 다 끝난 이후에 위쪽길 탐색
			 */
			if (mazeMatrix[x+1][y] == 1) {
				System.out.println(x + "," + y + " 에서 " + (x + 1) + "," + y + "로 이동");
				DFS(x+1, y, length + 1);
			}

			/**
			 * 위쪽 길이 존재하면 위쪽 길 탐색, 위쪽 길 탐색이 다 끝난 이후에 아래쪽 길 탐색
			 */
			if (mazeMatrix[x][y - 1] == 1) {
				System.out.println(x + "," + y + " 에서 " + x  + "," + (y - 1) + "로 이동");
				DFS(x, y - 1, length + 1);
			}

			/**
			 * 아래쪽 길이 존재하면 아래쪽 길 탐색, 아래쪽 길이 다 탐색이 끝나면 종료
			 */
			if (mazeMatrix[x][y + 1] == 1) {
				System.out.println(x + "," + y + " 에서 " + x  + "," + (y + 1) + "로 이동");
				DFS(x, y + 1, length + 1);
			}

			System.out.println("더이상 길이 존재하지 않네요 : " + x + "," + y);

			/**
			 * 방문 탐색 끝난 지점은 미 방문으로 만듬
			 */
			mazeMatrix[x][y] = 1;
		}
	}
}
