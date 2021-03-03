package binarytree;

public class MyBinaryTree {

	int numInTree;
	StudentInfo root;

	public MyBinaryTree() {
		this.numInTree = 0;
		this.root = null;
	}

	public void addToTree(StudentInfo root, StudentInfo student) {
		this.numInTree++;
		if (this.root == null) {
			this.root = student;
			return;
		}
		if (student.studentNumber < root.studentNumber)
			if (root.left != null)
				this.addToTree(root.left, student);
			else
				root.left = student;
		else if (root.right != null)
			this.addToTree(root.right, student);
		else
			root.right = student;
	}

	public void preorder(StudentInfo root) {
		if (root == null)
			return;
		printInfo(root);
		preorder(root.left);
		preorder(root.right);
	}

	public void postorder(StudentInfo root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		printInfo(root);
	}

	public void inorder(StudentInfo root) {
		if (root == null)
			return;
		inorder(root.left);
		printInfo(root);
		inorder(root.right);
	}

	private void printInfo(StudentInfo info) {
		System.out.print(info.studentNumber + " ");
//		System.out.println("[" + info.studentNumber + "] " + info.firstName + " " + info.lastName);
	}

}
