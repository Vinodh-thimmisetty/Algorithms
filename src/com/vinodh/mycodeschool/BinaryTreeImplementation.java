package com.vinodh.mycodeschool;

public class BinaryTreeImplementation {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(10);
		binaryTree.insert(5);
		binaryTree.insert(2);
		binaryTree.insert(0);
		binaryTree.printTrees(binaryTree.getRootNode());
		System.out.println();
		System.out.println("-------Recursive-----");
		BinaryTree binaryTree1 = new BinaryTree();
		binaryTree1.setRootNode(binaryTree1.insertRecursion(binaryTree1.getRootNode(), 10));
		binaryTree1.setRootNode(binaryTree1.insertRecursion(binaryTree1.getRootNode(), 5));
		binaryTree1.setRootNode(binaryTree1.insertRecursion(binaryTree1.getRootNode(), 2));
		binaryTree1.setRootNode(binaryTree1.insertRecursion(binaryTree1.getRootNode(), 0));
		binaryTree1.printTrees(binaryTree1.getRootNode());

		BinaryTree binaryTree11 = new BinaryTree();
		binaryTree11.insertRecursion(binaryTree11.getRootNode(), 10);
		binaryTree11.insertRecursion(binaryTree11.getRootNode(), 5);
		binaryTree11.insertRecursion(binaryTree11.getRootNode(), 2);
		binaryTree11.insertRecursion(binaryTree11.getRootNode(), 0);
		System.out.println();
		binaryTree11.printTrees(binaryTree11.getRootNode());
		System.out.println(binaryTree11.search(binaryTree11.getRootNode(), 5));

		// min and max of 15,10,20,8,12,17,25
		BinaryTree tree = new BinaryTree();
		tree.insertRecursion(tree.getRootNode(), 15);
		tree.insertRecursion(tree.getRootNode(), 10);
		tree.insertRecursion(tree.getRootNode(), 20);
		tree.insertRecursion(tree.getRootNode(), 25);
		tree.insertRecursion(tree.getRootNode(), 17);
		tree.insertRecursion(tree.getRootNode(), 8);
		tree.insertRecursion(tree.getRootNode(), 12);
		tree.printTrees(tree.getRootNode());

	}
}

class BinaryTree {
	private BinaryTreeNode rootNode;

	public BinaryTree() {
		this.rootNode = null;
	}

	public void setRootNode(BinaryTreeNode root) {
		this.rootNode = root;
	}

	public BinaryTreeNode getRootNode() {
		return rootNode;
	}

	public void insert(int data) {
		BinaryTreeNode node = new BinaryTreeNode(data);
		if (this.rootNode == null) {
			this.rootNode = node;
		} else {
			BinaryTreeNode temp = this.rootNode;
			BinaryTreeNode parent = null;
			while (temp != null) {
				if (data <= temp.data) {// left
					parent = temp;
					temp = temp.leftNode;
				} else {// right
					parent = temp;
					temp = temp.rightNode;
				}
			}
			// System.out.println(parent.data + "-----" + data);
			if (parent.data > data) {
				parent.leftNode = node;
			} else {
				parent.rightNode = node;
			}

		}
	}

	public BinaryTreeNode insertRecursion(BinaryTreeNode node, int data) {
		if (this.rootNode == null) {
			this.rootNode = new BinaryTreeNode(data);
			return this.rootNode;
		}
		if (node == null) {
			node = new BinaryTreeNode(data);
		} else {
			if (node.data >= data) {
				node.leftNode = insertRecursion(node.leftNode, data);
			} else {
				node.rightNode = insertRecursion(node.rightNode, data);
			}
		}
		return node;
	}

	/**
	 * prints data in the Left Sub tree an then Right Sub tree
	 * 
	 */
	public void printTrees(BinaryTreeNode node) {
		 if (node == null) {
			 System.out.print(node.data + "-->");
		
		 } else {
			//System.out.print(node.data + "-->");
			if (node.leftNode != null) {
				node = node.leftNode;
				//System.out.print(temp.data + "-->");
				printTrees(node);
	
			} 
			if (node.rightNode != null) {
				node = node.rightNode;
				//System.out.print(temp.data + "-->");
				printTrees(node);
				
			}
			
		}
	}

	public boolean search(BinaryTreeNode node, int data) {

		if (node == null) {
			return false;
		} else if (node.data == data) {
			return true;
		} else if (node.data > data) {
			return search(node.leftNode, data);
		} else {
			return search(node.rightNode, data);
		}

	}

	public void maxAndMinElements(BinaryTreeNode node) {
		BinaryTreeNode left = node, right = node;
		while (left != null) {
			left = left.leftNode;
		}
		System.out.println("Min Element is ----->" + left.data);
		while (right != null) {
			right = right.rightNode;
		}
		System.out.println("Max Element is ----->" + right.data);

	}

}

class BinaryTreeNode {
	public int data;
	public BinaryTreeNode leftNode;
	public BinaryTreeNode rightNode;

	public BinaryTreeNode(int data) {
		this.data = data;
	}
}
