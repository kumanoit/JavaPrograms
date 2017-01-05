package com.kumanoit.crackingTheCodingInterview.stacksQueues;

import java.util.Stack;

public class StackUtils {

	public static <T> void printStack(Stack<T> stack) {
		if (stack.size() == 0) {
			System.out.println("Empty stack");
			return;
		}
		System.out.print("Stack : ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + "\t");
		}
		System.out.println();
	}
}
