package com.vinodh.mycodeschool;

public class LinkedListImplementation {
	public static void main(String[] args) {
		LinkList linkList = new LinkList();// null->
		linkList.insert(100);// 100->null
		linkList.insert(200);// 200->100->null
		linkList.insert(300);// 300->200->100->null
		linkList.printList();
		linkList.insertAtEnd(400);//300->200->100->400->NULL
		linkList.printList();
		linkList.insertAtParticularLocation(3, 500);//300->200->500->100->400->NULL
		linkList.printList();
		linkList.deleteAtParticularPosition(2);//300->500->100->400->NULL
		linkList.printList();
		linkList.middleElement();//500
	}
}

class LinkList {
	private Node head;

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
			temp = temp.nextLink; // n-1 th node
		}
		Node deletedNode = temp.nextLink;
		temp.nextLink = deletedNode.nextLink;

	}

}

class Node {
	public int data;
	public Node nextLink;

	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return this.data;
	}
}
