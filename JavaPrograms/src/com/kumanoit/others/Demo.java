package com.kumanoit.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Demo {

	private static void printList(List<Integer> list) {
		System.out.println("List");
		list.forEach(item -> System.out.print(item + "\t"));
		System.out.println();
	}
	public static void main(String[] args) {
		learningOptional();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1); list.add(2); list.add(3); list.add(4);
		List<Integer> copy = new ArrayList(list);
		
		printList(list);
		printList(copy);
		list.add(10); list.add(20); list.add(2341); list.add(234241); 
		printList(list);
		printList(copy);
		
//		String line  = "My name is Amit Kumar";
//		StringTokenizer tokens = new StringTokenizer(line);
//		while(tokens.hasMoreElements()) {
//			System.out.println(tokens.nextToken());
//		}
	}

	private static void learningOptional() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	}
}
