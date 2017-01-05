package com.kumanoit.crackingTheCodingInterview.stacksQueues;

import java.util.Stack;

public class StackAndQueues {

	public static void testSortUsingTwoStacks() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(8);
		stack.push(4);
		stack.push(2);
		stack.push(1);
		stack.push(6);
		stack.push(3);
		stack.push(9);
		Stack<Integer> stackCopy = (Stack<Integer>) stack.clone();
		System.out.println("Sorting using 2 extra stacks");
		StackUtils.printStack((Stack<Integer>) stack.clone());
		stack = StacksQueuesSolution.sortUsingTwoExtraStacks(stack);
		StackUtils.printStack((Stack<Integer>) stack.clone());

		System.out.println("\nSorting using 1 extra stack");
		StackUtils.printStack((Stack<Integer>) stackCopy.clone());
		stackCopy = StacksQueuesSolution.sortUsingSingleExtraStack(stack);
		StackUtils.printStack((Stack<Integer>) stackCopy.clone());

		Stack<String> stringStack = new Stack<String>();
		stringStack.push("Flipkart");
		stringStack.push("Infosys");
		stringStack.push("Microsoft");
		stringStack.push("Google");
		stringStack.push("Facebook");
		stringStack.push("Adobe");
		stringStack.push("Amazon");
		Stack<String> stringStackCopy = (Stack<String>) stringStack.clone();

		System.out.println("\n\nSorting using 2 extra stacks");
		StackUtils.printStack((Stack<Integer>) stringStack.clone());
		stringStack = StacksQueuesSolution.sortUsingTwoExtraStacks(stringStack);
		StackUtils.printStack((Stack<Integer>) stringStack.clone());

		System.out.println("\nSorting using 1 extra stack");
		StackUtils.printStack((Stack<Integer>) stringStackCopy.clone());
		stringStackCopy = StacksQueuesSolution.sortUsingTwoExtraStacks(stringStack);
		StackUtils.printStack((Stack<Integer>) stringStackCopy.clone());
	}

	public static void main(String[] args) {
		testSortUsingTwoStacks();
	}

}
