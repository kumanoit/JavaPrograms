package com.kumanoit.crackingTheCodingInterview.stacksQueues.DogsAndCats;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 3.6 Animal Shelter: An animal shelter, which holds only dogs and cats,
 * operates on a strictly"first in, first out" basis. People must adopt either
 * the "oldest" (based on arrival time) of all animals at the shelter, or they
 * can select whether they would prefer a dog or a cat (and will receive the
 * oldest animal of that type). They cannot select which specific animal they
 * would like. Create the data structures to maintain this system and implement
 * operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may
 * use the built-in Linked list data structure. Hints: #22, #56, #63
 */

public class MyQueue<T extends Animal> {

	Queue<Cat> cats;
	Queue<Dog> dogs;
	private Long counter;

	MyQueue() {
		cats = new LinkedList<Cat>();
		dogs = new LinkedList<Dog>();
		counter = 0L;
	}

	public void enqueue(T animal) {
		if (animal instanceof Cat) {
			cats.add((Cat) animal);
		} else if (animal instanceof Dog) {
			dogs.add((Dog) animal);
		}
		animal.setAdmitTime(counter);
		counter++;
	}

	public Animal dequeueAny() {
		if (cats.isEmpty() && dogs.isEmpty()) {
			throw new EmptyStackException();
		}
		if (cats.isEmpty()) {
			return dogs.remove();
		}
		if (dogs.isEmpty()) {
			return cats.remove();
		}
		if (cats.peek().getAdmitTime() < dogs.peek().getAdmitTime()) {
			return cats.remove();
		} else {
			return dogs.remove();
		}
	}

	public Dog dequeueDog() {
		return dogs.remove();
	}

	public Cat dequeueCat() {
		return cats.remove();
	}

	public void print() {
		if (cats.size() == 0) {
			System.out.println("There are no cats");
		} else {
				System.out.println("Cats :");
				cats.forEach(item -> item.print());
		}
		if (dogs.size() == 0) {
			System.out.println("There are no dogs");
		} else {
				System.out.println("Dogs :");
				dogs.forEach(item -> item.print());
		}
		System.out.println();
	}
}
