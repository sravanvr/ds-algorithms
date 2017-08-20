package io.sv.pochecole.algorithms;

public class BinarySearchTree2 {

	class Node{
		int element;
		Node left = null;
		Node right = null;
	}

	private Node root;
	private Node parent;
	private Node inOrderParent;

	private void addNode(int ele){
		Node temp;
		if (root == null){
			root = new Node();
			root.element = ele;
		}
		else{
			temp = root;
			while(true){
				if (ele <=temp.element){
					if (temp.left != null)
						temp = temp.left;
					else{
						temp.left = new Node();
						temp.left.element = ele;
						break;
					}
				}
				else{
					if (temp.right != null)
						temp = temp.right;
					else{
						temp.right = new Node();
						temp.right.element = ele;
						break;
					}
				}
			}
		}
	}

	void inOrderTraverse(Node root){
		if (root !=null){
			inOrderTraverse(root.left);
			System.out.print("\t"+ root.element);
			inOrderTraverse(root.right);
		}
	}

	void inOrderTraverse(){
		
		inOrderTraverse (root);
	}
	
	void createBST(int a[]){
		
		root = null;
		
		for (int i=0; i<a.length; i++){
			addNode(a[i]);
		}
		inOrderTraverse(root);
	}

	void insertNode(int ele){
		addNode(ele);
	}

	Node findDeletedNode(int ele){
		Node temp;
		parent = null; 
		temp = root;

		while (temp!=null){
			if (ele == temp.element) 
				return temp;
			else if (ele < temp.element){
				parent = temp;	
				temp = temp.left;
			}
			else if (ele > temp.element){
				parent = temp;
				temp = temp.right;
			}
		}

		return null;
	}

	Node findInorderSuccessor(Node inParent, Node temp){
		inOrderParent = inParent;
		while (temp.left != null){
			inOrderParent = temp;
			temp = temp.left;
		}
		return temp;
	}

	Node findSuccessor(Node inParent, Node temp){
		inOrderParent = inParent;
		while (temp.right != null){
			inOrderParent = temp;
			temp = temp.right;
		}
		return temp;
	}
	
	void deleteNode(int deleteEle){
		System.out.println("\nElement deleted: " + deleteEle);
		Node deleteNode = findDeletedNode(deleteEle);
		
		if (deleteNode != null){
			
			while (true){				
				if (parent== null){
					Node successor = null;
					parent = root;
					if (root.right !=null)
						successor = findInorderSuccessor(deleteNode, deleteNode.right);
					else if (root.left !=null)
						successor = findSuccessor(deleteNode, deleteNode.left);
					else{
						root = null;
						return;
					}
					parent.element = successor.element;
					parent = inOrderParent;
					deleteNode = successor;
					deleteEle = successor.element;
				}
				
				else if (parent.left !=null && parent.left.element == deleteEle){
					
					if (deleteNode.left == null && deleteNode.right == null){
						parent.left = null;
						break;
					}
					else if (deleteNode.left != null && deleteNode.right == null){
						parent.left = deleteNode.left;
						break;
					}
					else if (deleteNode.left == null && deleteNode.right != null){
						parent.left = deleteNode.right;
						break;
					}
					else if (deleteNode.left != null && deleteNode.right != null){
							
						Node successor = findInorderSuccessor(deleteNode, deleteNode.right);
						
						parent.left.element = successor.element;
						parent = inOrderParent;
						deleteNode = successor;
						deleteEle = successor.element;
					}
				}
				
				else if (parent.right!=null && parent.right.element == deleteEle){
					
					if (deleteNode.left == null && deleteNode.right == null){
						parent.right = null;
						break;
					}
					else if (deleteNode.left != null && deleteNode.right == null){
						parent.right = deleteNode.left;
						break;
					}
					else if (deleteNode.left == null && deleteNode.right != null){
						parent.right = deleteNode.right;
						break;
					}
					else if (deleteNode.left != null && deleteNode.right != null){
						
						Node successor = findInorderSuccessor(deleteNode, deleteNode.right);
						
						parent.right.element = successor.element;
						parent = inOrderParent;
						deleteNode = successor;
						deleteEle = successor.element;
					}
				}
			}
			
			
		}
		else {
			System.out.println("Element not found in the BST tree");
		}
	}
	public static void main(String[] args) {
		
		int a[] = {60,68,120,130,155,190,65,77,125,175,75,80,150,100}; //{10,40,20,10,25,22};
		int b[] = {100,70,200,40,90,150,300,125,175,160,190,155,165,180,195,156};
		int c[] = {100,90,80,70,60,50,40};
		int d[] = {40};
		
		BinarySearchTree2 bst = new BinarySearchTree2();
		bst.createBST(d);		
		bst.deleteNode(40);		
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(70);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(90);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(100);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(125);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(150);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(155);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(156);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(160);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(165);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(175);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(180);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(190);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(195);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(200);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
		bst.createBST(b);
		bst.deleteNode(300);
		bst.inOrderTraverse();
		System.out.println("\n------------------------------------------------------");
		
	}

}
