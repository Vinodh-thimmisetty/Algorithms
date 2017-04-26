package com.vinodh.competition;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseStringUsingStack {

	public static void main(String[] args) {
		String s = "Hello";
		Stack<Character> ch = new Stack<>();
		char[] characters = s.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			ch.push(characters[i]);
		}

		System.out.println(Arrays.toString(characters));
		for (int i = 0; i < characters.length; i++) {
			System.out.println(ch.pop());
		}

		System.out.println("---- No extra space --- ");

		for (int i = 0, j = characters.length; i < characters.length; i++, j--) {
			if (i >= j) {
				// swap the elements i with j
			}
		}

		Stack<LinkedList<Character>> lists = new Stack<>();
		String s1 = "Hello";
		char[] chrs = s1.toCharArray();
		LinkedList<Character> linkedList = new LinkedList<>();
		for (int i = 0; i < characters.length; i++) {
			linkedList.add(chrs[i]);
		}
		lists.add(linkedList);
		
		

		
	}

}
