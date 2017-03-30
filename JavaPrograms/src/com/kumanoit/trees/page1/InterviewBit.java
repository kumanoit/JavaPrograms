package com.kumanoit.trees.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import com.kumanoit.trees.TreeSamples;
import com.kumanoit.trees.utils.Tree;

public class InterviewBit {

	public static void main(String[] args) {
		Hashtable table = new Hashtable();
		table.put("string", 9);
		table.put(8, 9);
		table.forEach((k, v) -> System.out.println(k + ", " +v));
//		testCreateTreeFromSortedArray();
//		ArrayList<ArrayList<Integer>> complete = new ArrayList<ArrayList<Integer>>();
//		TreeSamples.root5.display();
//		pathSum(TreeSamples.root5, 22, new ArrayList<Integer>(), complete);
//		complete.forEach(list -> {
//			System.out.println("\nList 1");
//			list.forEach(item -> System.out.print(item + "\t"));
//		});
	}

	public ArrayList<ArrayList<Integer>> pathSum(Tree root, int sum) {
		ArrayList<ArrayList<Integer>> complete = new ArrayList<ArrayList<Integer>>();
		pathSum(root, sum, new ArrayList<Integer>(), complete);
		return complete;
	}

	private static void pathSum(Tree root, int sum, ArrayList<Integer> list, 
			ArrayList<ArrayList<Integer>> complete) {
		if (root == null) {
			return;
		}
		sum -= root.getData();
		list.add(root.getData());
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			if (sum == 0) {
				complete.add(new ArrayList<Integer>(list));
			}
		}
		pathSum(root.getLeftChild(), sum, list, complete);
		pathSum(root.getRightChild(), sum, list, complete);
		list.remove(list.size() - 1);
	}
}
