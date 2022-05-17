package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeC = new BinaryTree<>("C");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		BinaryTree<String> nodeA = new BinaryTree<>("A");
		
		// knoop D heeft links C en rechts E
		BinaryTree<String> nodeD = new BinaryTree<>("D",nodeC, nodeE);
		// knoop I heeft links H
		BinaryTree<String> nodeI = new BinaryTree<>("I",nodeH,null);
		// knoop B heeft links A en rechts D
		BinaryTree<String> nodeB = new BinaryTree<>("B",nodeA, nodeD);
		// knoop G heeft rechts I
		BinaryTree<String> nodeG = new BinaryTree<>("G",null,nodeI);
		
		// boom heeft root F en heeft links B en rechts G
		BinaryTree<String> boom = new BinaryTree<>("F",nodeB, nodeG);
//		boom.printPreorder();
//		boom.printInorder();
//		boom.printPostorder();
//		System.out.println(boom.countNodes());
//		System.out.println(nodeB.isLeaf());
//		System.out.println(boom.contains("A"));
		System.out.println(boom.countLeaves());
	}

}
