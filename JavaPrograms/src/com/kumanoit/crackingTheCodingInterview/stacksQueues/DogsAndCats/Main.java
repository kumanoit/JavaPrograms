package com.kumanoit.crackingTheCodingInterview.stacksQueues.DogsAndCats;

public class Main {

	public static void main(String[] args) {
		Dog dog0 = new Dog("dog0");
		Cat cat1 = new Cat("cat1");
		Dog dog2 = new Dog("dog2");
		Dog dog3 = new Dog("dog3");
		Cat cat4 = new Cat("cat4");
		Cat cat5= new Cat("cat5");
		Dog dog6 = new Dog("dog6");
		Cat cat7 = new Cat("cat7");
		Cat cat8 = new Cat("cat8");
		Dog dog9 = new Dog("dog9");
		Dog dog10 = new Dog("dog10");
		Cat cat11 = new Cat("cat11");
		Dog dog12 = new Dog("dog12");
		Dog dog13 = new Dog("dog13");
		Cat cat14 = new Cat("cat14");
		Dog dog15 = new Dog("dog15");
		Dog dog16 = new Dog("dog16");
		MyQueue<Animal> queue = new MyQueue<Animal>();
		queue.enqueue(dog0);
		queue.enqueue(cat1);
		queue.enqueue(dog2);
		queue.enqueue(dog3);
		queue.enqueue(cat4);
		queue.enqueue(cat5);
		queue.enqueue(dog6);
		queue.enqueue(cat7);
		queue.enqueue(cat8);
		queue.enqueue(dog9);
		queue.enqueue(dog10);
		queue.enqueue(cat11);
		queue.enqueue(dog12);
		queue.enqueue(dog13);
		queue.enqueue(cat14);
		queue.enqueue(dog15);
		queue.enqueue(dog16);
		queue.print();
		System.out.println();
		System.out.println("Any " + queue.dequeueAny().getName());
		System.out.println("Dog " + queue.dequeueDog().getName());
		System.out.println("Any " + queue.dequeueAny().getName());
		System.out.println("Any " + queue.dequeueAny().getName());
		System.out.println("Dog " + queue.dequeueDog().getName());
		System.out.println("Any " + queue.dequeueAny().getName());
		System.out.println("Dog " + queue.dequeueDog().getName());
		System.out.println("Cat " + queue.dequeueCat().getName());
		System.out.println("Any " + queue.dequeueAny().getName());
		System.out.println("Dog " + queue.dequeueDog().getName());
		System.out.println("Cat " + queue.dequeueCat().getName());
		System.out.println("Any " + queue.dequeueAny().getName());
		System.out.println("Any " + queue.dequeueAny().getName());
	}
}
