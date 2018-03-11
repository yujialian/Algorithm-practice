
public class BinarySearchTree {
	public class Node {
		int val;
		Node left;
		Node right;
		public Node() {
			this.val = 0;
			this.left = this.right = null;
		}
		public Node(int val) {
			this.val = val;
		}
	}
	Node root;
	int size;
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void insert(int val) {
		if(root == null) {
			root = new Node(val);
			return;
		}
		Node parent = null;
		Node current = root;
		while(current != null) {
			parent = current;
			if(current.val == val) {
				return;
			} else if(current.val > val) {
				current = current.left;
				if(current == null) {
					parent.left = new Node(val);
				}
			} else if(current.val < val) {
				current = current.right;
				if(current == null) {
					parent.right = new Node(val);
				}
			}
		}
	}
	public boolean find(int val) {
		Node current = root;
		while(current != null) {
			if(current.val == val) {
				return true;
			} else if(current.val > val) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}
	public boolean delete(int val) {
		Node parent = root;
		Node target = root;
		boolean isLeftChild = false;
		while(target.val != val) {
			parent = target;
			if(target.val > val) {
				target = target.left;
				isLeftChild = true;
			} else {
				target = target.right;
				isLeftChild = false;
			}
			if(target == null) return false;
		}
		/*Target have no children*/
		if(target.left == null && target.right == null) {
			if(isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		/*target have one(left) children*/
		if(target.left != null && target.right == null) {
			if(isLeftChild == true) {
				Node dummy = target.left;
				target.left = null;
				parent.left = dummy;
			} else {
				Node dummy = target.left;
				target.left = null;
				parent.right = dummy;
			}
		}
		if(target.right != null && target.left == null) {
			if(isLeftChild == true) {
				Node dummy = target.right;
				target.right = null;
				parent.left = dummy;
			} else {
				Node dummy = target.right;
				target.right = null;
				parent.right = dummy;
			}
		}
		/*Have both children*/
		if(target.left != null && target.right != null) {
			Node successor = leftSuccessor(target);
			if(target == root) {
				root = successor;
			} else if(isLeftChild == true) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			//successor.left = target.left;
			successor.right = target.right;
		}
		return true;
	}
	public Node successor(Node target) {
		Node successor = null;
		Node successorParent = null;
		Node current = target.right;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
			}
		if(successor != target.right) {
			successorParent.left = successor.right;
			successor.right = target.right;
		}
		return successor;
	}
	public Node leftSuccessor(Node target) {
		Node successor = null;
		Node successorParent = null;
		Node current = target.left;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.right;
		}
		if(successor != target.left) {
			successorParent.right = successor.left;
			successor.left = target.left;
		}
		return successor;
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.val);
			display(root.right);
		}
	}
	public static void main(String arg[]){
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(b.root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(b.root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(b.root);
	}
	
}
