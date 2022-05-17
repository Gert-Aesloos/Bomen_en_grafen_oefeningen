package ui;

import domain.BinaryTree;

public class BinairyTreeDriver1 {

    public static void main(String[] args) {
        BinaryTree<String> node1 = new BinaryTree<>("A");
        BinaryTree<String> node2 = new BinaryTree<>("E");
        BinaryTree<String> node3 = new BinaryTree<>("E");
        BinaryTree<String> node4 = new BinaryTree<>("E");
        BinaryTree<String> node5 = new BinaryTree<>("E");


        BinaryTree<String> node11 = new BinaryTree<>("C",null,node2);
        BinaryTree<String> node12 = new BinaryTree<>("H",null,node4);

        BinaryTree<String> node21 = new BinaryTree<>("H",node11,node3);
        BinaryTree<String> node22 = new BinaryTree<>("I",node12,node5);

        BinaryTree<String> node31 = new BinaryTree<>("H",node1,node21);
        BinaryTree<String> node32 = new BinaryTree<>("G",null,node22);

        BinaryTree<String> boom = new BinaryTree<>("A",node31,node32);

        System.out.println(boom.count("I"));
        System.out.println(boom.count("A"));
        System.out.println(boom.count("H"));
        System.out.println(boom.count("E"));
        System.out.println(boom.count("Q"));
    }
}
