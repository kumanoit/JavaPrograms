package com.kumanoit.linkedlist.page2;

import com.kumanoit.linkedlist.LinkList;

public class Solution2 {

	public static LinkList rearrangeEvenOddNodes(LinkList start) {
		LinkList evenStart = null;
		LinkList oddStart = null;
		LinkList ptr = start;
		while (ptr != null) {
			LinkList nextPtr = ptr.getNextNode();
			if ((ptr.getData() & 1) == 1) {
				ptr.setNextNode(oddStart);
				oddStart = ptr;
			} else {
				ptr.setNextNode(evenStart);
				evenStart = ptr;
			}
			ptr = nextPtr;
		}
		if (evenStart != null && oddStart != null) {
			ptr = evenStart;
			while (ptr.getNextNode() != null) {
				ptr = ptr.getNextNode();
			}
			ptr.setNextNode(oddStart);
			return evenStart;
		} else if (evenStart != null) {
			return evenStart;
		} else {
			return oddStart;
		}
	}

	public static LinkList mergeLinkListInReverseOrder(LinkList start1, LinkList start2) {
		LinkList mergedStart = null;
		LinkList ptr1 = start1;
		LinkList ptr2 = start2;
		while (ptr1 != null && ptr2 != null) {
			if (ptr1.getData() < ptr2.getData()) {
				LinkList nextPtr = ptr1.getNextNode();
				ptr1.setNextNode(mergedStart);
				mergedStart = ptr1;
				ptr1 = nextPtr;
			} else {
				LinkList nextPtr = ptr2.getNextNode();
				ptr2.setNextNode(mergedStart);
				mergedStart = ptr2;
				ptr2 = nextPtr;
			}
		}
		while (ptr1 != null) {
			LinkList nextPtr = ptr1.getNextNode();
			ptr1.setNextNode(mergedStart);
			mergedStart = ptr1;
			ptr1 = nextPtr;
		}
		while (ptr2 != null) {
			LinkList nextPtr = ptr2.getNextNode();
			ptr2.setNextNode(mergedStart);
			mergedStart = ptr2;
			ptr2 = nextPtr;
		}
		return mergedStart;
	}

	public static LinkList rearrange(LinkList start) {
		if (start == null || start.getNextNode() == null) {
			return start;
		}
		boolean flag = true;
		LinkList ptr = start;

		while (ptr != null && ptr.getNextNode() != null) {
			LinkList nextNode = ptr.getNextNode();
			if (flag) {
				if (nextNode.getData() < ptr.getData()) {
					int temp = ptr.getData();
					ptr.setData(nextNode.getData());
					nextNode.setData(temp);
				}
			} else {
				if (nextNode.getData() > ptr.getData()) {
					int temp = ptr.getData();
					ptr.setData(nextNode.getData());
					nextNode.setData(temp);
				}
			}
			flag = !flag;
			ptr = nextNode;
		}
		return start;
	}
}
