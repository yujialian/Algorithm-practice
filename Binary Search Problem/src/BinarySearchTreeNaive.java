public class BinarySearchTreeNaive {
	
	public class Node {
		Node left;
		Node right;
		int val;
		public Node(int val) {
			this.val = val;
			left = right = null;
		}
	}
	Node root;
	int size = 0;
	public BinarySearchTreeNaive(int val) {
		root = new Node(val);
		size = 1;
	}
	public BinarySearchTreeNaive() {
		size = 0;
		root = null;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void insert(int val) {
		Node node = new Node(val);
		Node current = root;
		Node parent = null;
		if(current == null) {
			root = new Node(val);
			return;
		}
		while(true) {
			parent = current;
			if(current.val == val) {
				return;
			} else if(current.val > val) {
				current = current.left;
				if(current == null) {
					parent.left = node;
					return;
				}
			} else if(current.val < val) {
				current = current.right;
				if(current == null) {
					parent.right = node;
					return;
				}
			}
		}
	}
	public boolean search(int val) {
		Node current = root;
		while(root != null) {
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
		if(root == null) return false;
		Node target = root;
		Node parent = root;
		boolean isLeftChild = false;
		while(target.val != val) {
			parent = target;
			if(target.val > val) {
				isLeftChild = true;
				target = target.left;
			} else {
				isLeftChild = false;
				target = target.right;
			}
			if(target == null) {
				return false;
			}
		}
		/*Target have no child*/
		if(target.left == null && target.right == null) {
			if(isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		/*Target only have left child*/
		if(target.right == null && target.left != null) {
			Node leftRemain = target.left;
			target.left = null;
			if(isLeftChild == true) {
				parent.left = leftRemain;
			} else {
				parent.right = leftRemain;
			}
		} else if(target.left == null && target.right != null) {
			Node rightRemain = target.right;
			target.right = null;
			if(isLeftChild == true) {
				parent.left = rightRemain;
			} else {
				parent.right = rightRemain;
			}
		}
		/*Target have both left and right child.*/
		else if(target.left != null && target.right != null) {
			Node successor = getLeftSuccessor(target);
			if(target == root) {
				root = successor;
			} else if(isLeftChild == true) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.right = target.right;
		}
		return true;
	}
	private Node getRightSuccessor(Node deleteNode) {
		Node successor = null;
		Node successorParent = null;
		Node current = deleteNode.right;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if(successor != deleteNode.right) {
			successorParent.left = successor.right;
			successor.right = deleteNode.right;
		}
		return successor;
	}
	private Node getLeftSuccessor(Node deleteNode) {
		Node successor = null;
		Node successorParent = null;
		Node current = deleteNode.left;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.right;
		}
		if(successor != deleteNode.left) {
			successorParent.right = successor.left;
			successor.left = deleteNode.left;
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
		BinarySearchTreeNaive b = new BinarySearchTreeNaive();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.search(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(b.root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(b.root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(b.root);
	}
}