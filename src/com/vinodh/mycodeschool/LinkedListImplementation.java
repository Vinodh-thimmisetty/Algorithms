package com.vinodh.mycodeschool;

public class LinkedListImplementation {
	public static void main(String[] args) {
		LinkList linkList = new LinkList();// null->
		linkList.insert(100);// 100->null
		linkList.insert(200);// 200->100->null
		linkList.insert(300);// 300->200->100->null
		linkList.printList();
		linkList.insertAtEnd(400);// 300->200->100->400->NULL
		linkList.printList();
		linkList.insertAtParticularLocation(3, 500);// 300->200->500->100->400->NULL
		linkList.printList();
		linkList.deleteAtParticularPosition(2);// 300->500->100->400->NULL
		linkList.printList();
		linkList.middleElement();// 500
		linkList.printList();
		linkList.reverseLinks();
		linkList.printList();
		linkList.insert(800);
		linkList.printRecursively(linkList.getHead());
		System.out.println("\n");
		System.out.println("-- Reverse Order Recursion----");
		linkList.reversePrintRecursion(linkList.getHead());
		System.out.println("\n");
		linkList.reverseLinkRecursion(linkList.getHead());
		System.out.println("\n");

		System.out.println("--------- Doubly Linked List -----------");

		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.insertDoubleLinkedListAtHead(2);
		doublyLinkedList.insertDoubleLinkedListAtHead(4);
		doublyLinkedList.insertDoubleLinkedListAtHead(6);
		doublyLinkedList.printDoubleLinkedList();
		doublyLinkedList.insertDoubleLinkedListAtEnd(10);
		doublyLinkedList.insertDoubleLinkedListAtHead(1);
		doublyLinkedList.insertDoubleLinkedListAtEnd(12);
		doublyLinkedList.printDoubleLinkedList();
	}
}

class LinkList {
	private Node head;

	public Node getHead() {
		return head;
	}

	public LinkList() {
		head = null;
	}

	// Print the elements in the Linked List
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.nextLink;
		}
		System.out.println("\n");

	}

	// print using Recursion
	public void printRecursively(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + "->");
		printRecursively(node.nextLink);

	}

	// Reverse Print using Recursion
	public void reversePrintRecursion(Node node) {
		if (node == null) {
			return;
		}

		reversePrintRecursion(node.nextLink);
		System.out.print(node.data + "-->");
	}

	// Traversing the Linked List till End
	public Node traverseTillEnd() {
		Node temp = head;
		while (temp.nextLink != null) {
			temp = temp.nextLink;
		}

		return temp;
	}

	// Traversing the Linked List to Particular Position
	public Node traverseToPosition(int position) {
		Node temp = head;
		for (int i = 0; i < position - 2; i++) {
			temp = temp.nextLink;
		}
		return temp;
	}

	// Print Value of Mid element
	public int middleElement() {
		Node temp1 = head;
		Node temp2 = head;

		while (temp2.nextLink != null) {
			if (temp2.nextLink.nextLink != null) {
				temp2 = temp2.nextLink.nextLink;
				temp1 = temp1.nextLink;
			} else {
				break;
			}

		}
		System.out.println("Middle element is ---" + temp1.data);
		return temp1.data;
	}

	// Inserting at Beginning of Linked List
	public void insert(int d) {
		Node node = new Node(d);
		node.nextLink = head;
		head = node;
	}

	// Insert @ End of the List
	public void insertAtEnd(int d) {
		Node node = new Node(d);
		Node endNode = traverseTillEnd();
		endNode.nextLink = node;
		node.nextLink = null;
	}

	// Insert @ Particular Position of the List
	public void insertAtParticularLocation(int position, int data) {
		Node testNode;
		Node node = new Node(data);
		if (position == 1) { // insert at head
			node.nextLink = head;
			head = node;
			return;
		}
		testNode = traverseToPosition(position);
		node.nextLink = testNode.nextLink;
		testNode.nextLink = node;
	}

	// Delete a node @ any given position
	public void deleteAtParticularPosition(int position) {
		Node temp = head;
		if (position == 1) { // insert at head
			head = temp.nextLink;
			return;
		}
		for (int i = 0; i < position - 2; i++) {
			temp = temp.nextLink; // n-1th node
		}
		Node deletedNode = temp.nextLink;
		temp.nextLink = deletedNode.nextLink;

	}

	// Reverse a linked List by adjusting the Links
	/**
	 * REVERSE THE LINKS From :: HEAD -> 1 -> 2 -> NULL To :: NULL <- 1 <- 2 <-
	 * HEAD
	 */
	public void reverseLinks() {
		Node current = this.head;
		Node prevNode = null, nextNode = null;

		while (current != null) {
			nextNode = current.nextLink;
			current.nextLink = prevNode; // end node points to null
			prevNode = current;
			current = nextNode;
		}

		head = prevNode;
	}

	// Reverse a linked List by adjusting the Links
	public void reverseLinkRecursion(Node currentNode) {
		if (currentNode.nextLink == null) {
			this.head = currentNode;
			return;
		}
		reverseLinkRecursion(currentNode.nextLink);
		Node nextNode = currentNode.nextLink;
		nextNode.nextLink = currentNode;
		currentNode.nextLink = null;
	}

}

class DoublyLinkedList {
	private DoubleLinkedNode dHead;

	public DoubleLinkedNode getdHead() {
		return dHead;
	}

	public DoublyLinkedList() {
		this.dHead = null;
	}

	public void printDoubleLinkedList() {
		DoubleLinkedNode temp = this.dHead;
		DoubleLinkedNode revTemp = this.dHead;
		while (temp != null) {
			System.out.print("<--" + temp.data + "-->");
			temp = temp.nextLink;
		}
		System.out.println("\n");

		System.out.print("--- In reverse Order ---");
		while (revTemp.nextLink != null) {
			revTemp = revTemp.nextLink;
		}
		while (revTemp != null) {
			System.out.print("<--" + revTemp.data + "-->");
			revTemp = revTemp.prevLink;
		}
		System.out.println("\n");

	}

	public void insertDoubleLinkedListAtEnd(int data) {
		DoubleLinkedNode doubleLinkedNode = new DoubleLinkedNode(data);
		if (this.dHead == null) {
			this.dHead = doubleLinkedNode;
			return;
		}
		DoubleLinkedNode temp = this.dHead;
		while (temp.nextLink != null) {
			temp = temp.nextLink;
		}
		doubleLinkedNode.prevLink = temp;
		temp.nextLink = doubleLinkedNode;
		temp = doubleLinkedNode;
	}

	public void insertDoubleLinkedListAtHead(int data) {
		DoubleLinkedNode doubleLinkedNode = new DoubleLinkedNode(data);
		if (this.dHead == null) {
			this.dHead = doubleLinkedNode;
			return;
		}
		this.dHead.prevLink = doubleLinkedNode;
		doubleLinkedNode.nextLink = this.dHead;
		this.dHead = doubleLinkedNode;

	}

}

class Node {
	public int data;
	public Node nextLink;

	public Node(int data) {
		this.data = data;
	}
}

class DoubleLinkedNode {
	public int data;
	public DoubleLinkedNode prevLink; // default null
	public DoubleLinkedNode nextLink; // default null

	public DoubleLinkedNode(int data) {
		this.data = data;
	}

}