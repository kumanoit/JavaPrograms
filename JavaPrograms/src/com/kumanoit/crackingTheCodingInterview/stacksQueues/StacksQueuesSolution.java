package com.kumanoit.crackingTheCodingInterview.stacksQueues;

import java.util.Stack;

public class StacksQueuesSolution {

	/**
	 * 3.1 Three in One: Describe how you could use a single array to implement
	 * three stacks. Hints: #2, #72, #38, #58
	 */

	/**
	 * 3.2 Stack Min: How would you design a stack which, in addition to push and
	 * pop, has a function min which returns the minimum element? Push, pop and
	 * min should all operate in 0(1) time. Hints:#27, #59, #78
	 */

	/**
	 * 3.3 Stack of Plates: Imagine a (literal) stack of plates. If the stack gets
	 * too high, it might topple. Therefore, in real life, we would likely start a
	 * new stack when the previous stack exceeds some threshold. Implement a data
	 * structure SetOfStacks that mimics this. SetOfStacks should be composed of
	 * several stacks and should create a new stack once the previous one exceeds
	 * capacity. SetOfStacks. push() and SetOfStacks. pop() should behave
	 * identically to a single stack (that is, pop () should return the same
	 * values as it would if there were just a single stack). FOLLOW UP Implement
	 * a function popAt ( int index) which performs a pop operation on a specific
	 * sub-stack. Hints:#64, #87 pg233
	 */

	/**
	 * 3.5 Sort Stack: Write a program to sort a stack such that the smallest
	 * items are on the top. You can use an additional temporary stack, but you
	 * may not copy the elements into any other data structure (such as an array).
	 * The stack supports the following operations: push, pop, peek, and is Empty.
	 * Hints:# 15, #32, #43 .... ...........................
	 * ............................ .................. P9 237
	 */
	public static <T extends Comparable<T>> Stack<T> sortUsingTwoExtraStacks(Stack<T> stack) {
		Stack<T> smaller = new Stack<T>();
		Stack<T> bigger = new Stack<T>();
		while (true) {
			while (!stack.isEmpty()) {
				T topMostElement = stack.pop();
				if (smaller.size() == 0 || smaller.peek().compareTo(topMostElement) >= 0) {
					smaller.push(topMostElement);
				} else {
					bigger.push(topMostElement);
				}
			}
			if (bigger.size() == 0) {
				return smaller;
			}
			while (!smaller.isEmpty()) {
				stack.push(smaller.pop());
			}
			while (!bigger.isEmpty()) {
				stack.push(bigger.pop());
			}
		}
	}

	public static <T extends Comparable<T>> Stack<T> sortUsingSingleExtraStack(Stack<T> stack) {
		Stack<T> sortedStack = new Stack<T>();
		while (!stack.isEmpty()) {
			T temp = stack.pop();
			while (!sortedStack.isEmpty() && sortedStack.peek().compareTo(temp) <= 0) {
				stack.push(sortedStack.pop());
			}
			sortedStack.push(temp);
		}
		return sortedStack;
	}

}
