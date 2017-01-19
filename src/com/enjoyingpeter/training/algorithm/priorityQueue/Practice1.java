package com.enjoyingpeter.training.algorithm.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 우선순위 큐를 자바 라이브러리를 이용해서 구현해봄
 */
public class Practice1 {
	public static void main(String[] args) {
		Prisoner prisoner1 = new Prisoner("james", 5);
		Prisoner prisoner2 = new Prisoner("schofield", 99);
		Prisoner prisoner3 = new Prisoner("alex", 14);
		Prisoner prisoner4 = new Prisoner("silvia", 10);
		Prisoner prisoner5 = new Prisoner("thomson", 1);

		PriorityQueue<Prisoner> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(prisoner1);
		priorityQueue.offer(prisoner2);
		priorityQueue.offer(prisoner3);
		priorityQueue.offer(prisoner4);
		priorityQueue.offer(prisoner5);

//		while(!priorityQueue.isEmpty()) {
//			System.out.println(priorityQueue.poll().name);
//		}

		System.out.println("=======================================");
		int size = priorityQueue.size();
		PriorityQueue<Prisoner> reverseQueue = new PriorityQueue<>(size, Collections.reverseOrder());
		reverseQueue.addAll(priorityQueue);

		while(!reverseQueue.isEmpty()) {
			System.out.println(reverseQueue.poll().name);
		}
	}
}

class Prisoner implements Comparable<Prisoner> {
	String name;
	int weight;

	public Prisoner(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public int compareTo(Prisoner o) {
		if (this.weight > o.weight) {
			return 1;
		} else if (this.weight < o.weight) {
			return -1;
		}

		return 0;
	}
}
