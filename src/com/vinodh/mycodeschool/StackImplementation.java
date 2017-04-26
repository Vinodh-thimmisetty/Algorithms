package com.vinodh.mycodeschool;

public class StackImplementation {

	public static void main(String[] args) {
		StackUsingArray usingArray = new StackUsingArray();
		usingArray.push(21);
		usingArray.printStack();
		usingArray.push(43);
		usingArray.printStack();
		usingArray.isEmpty();
		usingArray.pop();
		usingArray.printStack();
		usingArray.push(23);
		usingArray.printStack();
		usingArray.push(22);
		usingArray.printStack();
	}

}

class StackUsingArray {
	public int[] a = new int[10];
	public int topOfStack = -1; // no elements

	public void push(int x) {
		int l = a.length;
		if (topOfStack >= l - 1) {
			System.out.println("Stack overflow");
			int[] temp = a;
			a = new int[2 * l];
			for (int i = 0; i < temp.length; i++) {
				a[i] = temp[i];
			}
		}
		topOfStack += 1;
		a[topOfStack] = x;
	}

	public void pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return;
		}
		topOfStack--;
	}

	public int peek() {
		return a[topOfStack];
	}

	public boolean isEmpty() {
		return (topOfStack == -1) ? true : false;
	}

	public int size() {
		return a.length;
	}

	public void printStack() {
		System.out.println("top is --->" + a[topOfStack]);
		for (int i = 0; i <= topOfStack; i++) {
			System.out.print(a[i] + "---->");
		}
		System.out.println("\n");
	}
}

class StackUsingLinkedList {

}
