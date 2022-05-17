package domain;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public boolean lookup(E data) {
		if (data.compareTo(this.data)==0){
			return true;
		}
		else {
			if (data.compareTo(this.data)==-1){
				if (leftTree==null){
					return false;
				}
				else {
					return leftTree.lookup(data);
				}
			}
			else {
				if (rightTree==null){
					return false;
				}
				else {
					return rightTree.lookup(data);
				}
			}
		}
	}

	public boolean addNode(E data) {
		if (data.compareTo(this.data)==0) {
			return false;
		}
		else {
			if (data.compareTo(this.data) == -1){
				if (leftTree==null){
					leftTree = new BinarySearchTree<>(data);
					return true;
				}
				else
				{
					return leftTree.addNode(data);
				}
			}
			else {
				if (rightTree==null){
					rightTree= new BinarySearchTree<>(data);
					return true;
				}
				else {
					return rightTree.addNode(data);
				}
			}
		}
	}

	public boolean removeNode(E data){
		if (data.compareTo(this.data)==0){
			if (this.isLeaf()){
				this.data=null;

				return true;
			}
			else{
				if (leftTree!=null){
					E gl=leftTree.searchGreatest();
					this.data=gl;
					leftTree.removeNode(gl);
					leftTree.cleanUp();
					return true;
				}
				else {
					E kr=rightTree.searchSmallest();
					this.data=kr;
					rightTree.removeNode(kr);
					rightTree.cleanUp();
					return true;
				}
			}
		}
		else {
			if (data.compareTo(this.data)==-1) {
				if (leftTree==null){
					return false;
				}
				else {
					return leftTree.removeNode(data);
				}
			}
			else {
				if (rightTree==null){
					return false;
				}
				else {
					return rightTree.removeNode(data);
				}
			}
		}
	}

	public boolean isLeaf() {
		return leftTree == null && rightTree == null;
	}

	public E searchSmallest(){
		if (this.leftTree==null) {
			return this.data;
		}
		else {
			return leftTree.searchSmallest();
		}
	}

	public E searchGreatest(){
		if (this.rightTree==null) {
			return this.data;
		}
		else {
			return rightTree.searchGreatest();
		}
	}

	public boolean cleanUp(){
		if (leftTree!=null) {
			if (this.leftTree.data==null){
				this.leftTree = null;
				return true;
			}
			else {
				return this.leftTree.cleanUp();
			}
		}
		if (rightTree!=null) {
			if (this.rightTree.data==null){
				this.rightTree=null;
			}
			else {
				return this.rightTree.cleanUp();
			}
		}
		return false;
	}
}


