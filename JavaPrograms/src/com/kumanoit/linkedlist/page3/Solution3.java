package com.kumanoit.linkedlist.page3;

import com.kumanoit.linkedlist.LinkList;

public class Solution3 {

	public static int getMaxSumLinkedList(LinkList start1, LinkList start2) {
		LinkList ptr1 = start1;
		LinkList ptr2 = start2;
		int sum1 = 0;
		int sum2 = 0;
		while (ptr1 != null && ptr2 != null) {
			if (ptr1.getData() < ptr2.getData()) {
				sum1 += ptr1.getData();
				ptr1 = ptr1.getNextNode();
			} else if (ptr1.getData() > ptr2.getData()) {
				sum2 += ptr2.getData();
				ptr2 = ptr2.getNextNode();
			} else {
				sum1 = sum2 = Math.max(sum1, sum2) + ptr1.getData();
				ptr1 = ptr1.getNextNode();
				ptr2 = ptr2.getNextNode();
			}
		}
		while (ptr1 != null) {
			sum1 += ptr1.getData();
			ptr1 = ptr1.getNextNode();
		}
		while (ptr2 != null) {
			sum2 += ptr2.getData();
			ptr2 = ptr2.getNextNode();
		}
		return Math.max(sum1, sum2);
	}

	public static LinkList constructLinkList(LinkList start1, LinkList start2) {
		LinkList ptr1 = start1;
		LinkList ptr2 = start2;
		LinkList newStart1 = start1;
		LinkList newStart2 = start2;
		LinkList newStart = null;
		LinkList lastNode = null;
		int sum1 = 0;
		int sum2 = 0;
		while (ptr1 != null && ptr2 != null) {
			if (ptr1.getData() < ptr2.getData()) {
				sum1 += ptr1.getData();
				ptr1 = ptr1.getNextNode();
			} else if (ptr1.getData() > ptr2.getData()) {
				sum2 += ptr2.getData();
				ptr2 = ptr2.getNextNode();
			} else {
				if (sum1 > sum2) {
					if (newStart == null) {
						newStart = newStart1;
					} else {
						lastNode.setNextNode(newStart1);
					}
					lastNode = ptr1;
				} else {
					if (newStart == null) {
						newStart = newStart2;
					} else {
						lastNode.setNextNode(newStart2);
					}
					lastNode = ptr2;
				}
				sum1 = sum2 = Math.max(sum1, sum2) + ptr1.getData();
				newStart1 = ptr1.getNextNode();
				newStart2 = ptr2.getNextNode();
				ptr1 = newStart1;
				ptr2 = newStart2;
			}
		}
		while (ptr1 != null) {
			sum1 += ptr1.getData();
			ptr1 = ptr1.getNextNode();
		}
		while (ptr2 != null) {
			sum2 += ptr2.getData();
			ptr2 = ptr2.getNextNode();
		}
		if (sum1 > sum2) {
			if (newStart == null) {
				newStart = newStart1;
			} else {
				lastNode.setNextNode(newStart1);
			}
			lastNode = ptr1;
		} else {
			if (newStart == null) {
				newStart = newStart2;
			} else {
				lastNode.setNextNode(newStart2);
			}
			lastNode = ptr2;
		}
		System.out.println("Max sum = " + Math.max(sum1, sum2));
		return newStart;
	}
}
