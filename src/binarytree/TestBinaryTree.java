package binarytree;

public class TestBinaryTree {

	final class Name {
		String first, last;

		public Name(String first, String last) {
			this.first = first;
			this.last = last;
		}
	}

	final Name[] names = { new Name("Cha", "Eun-woo"), new Name("Gwen", "Brant"), new Name("Emily", "Dickenson"),
			new Name("Donald", "Trump"), new Name("Nichola", "Tesla"), new Name("Kim", "Yo-han"),
			new Name("Abraham", "Lincoln"), new Name("Louis", "Armstrong"), new Name("Rosa", "Parks"),
			new Name("Malcolm", "X"), new Name("Pierre", "Trudeau") };

	public TestBinaryTree() {
		MyBinaryTree t = new MyBinaryTree();
		t.root = newStudent(0);

//		t.preorder(t.root);
//		t.postorder(t.root);
//		t.inorder(t.root);

		for (int i = 1; i <= 10; ++i)
			t.addToTree(t.root, newStudent(i));

		System.out.println("First test...");
		System.out.println("\nPreorder");
		t.preorder(t.root);
		System.out.println("\nPostorder");
		t.postorder(t.root);
		System.out.println("\nInorder");
		t.inorder(t.root);
		System.out.print("\nNumber of students: " + t.numInTree);
		System.out.println();

		System.out.println("\n\nSecond test...");
		MyBinaryTree t2 = new MyBinaryTree();
		t2.root = newStudent(1);
		t2.root.left = newStudent(2);
		t2.root.left.left = newStudent(4);
		t2.root.left.right = newStudent(5);
		t2.root.right = newStudent(3);
		t2.root.right.left = newStudent(6);
		t2.root.right.right = newStudent(7);

		System.out.println("\nPreorder");
		t2.preorder(t2.root);
		System.out.println("\nPostorder");
		t2.postorder(t2.root);
		System.out.println("\nInorder");
		t2.inorder(t2.root);
		System.out.print("\nNumber of students: 7");
		System.out.println();

		System.out.println("\n\nThird test...");
		MyBinaryTree t3 = new MyBinaryTree();

		t3.addToTree(t3.root, newStudent(5));
		t3.addToTree(t3.root, newStudent(6));
		t3.addToTree(t3.root, newStudent(3));
		t3.addToTree(t3.root, newStudent(1));
		t3.addToTree(t3.root, newStudent(2));
		t3.addToTree(t3.root, newStudent(8));
		t3.addToTree(t3.root, newStudent(9));
		t3.addToTree(t3.root, newStudent(10));
		t3.addToTree(t3.root, newStudent(7));
		t3.addToTree(t3.root, newStudent(0));

		System.out.println("\nPreorder");
		t3.preorder(t3.root);
		System.out.println("\nPostorder");
		t3.postorder(t3.root);
		System.out.println("\nInorder");
		t3.inorder(t3.root);
		System.out.print("\nNumber of students: " + t3.numInTree);
		System.out.println();
	}

	private StudentInfo newStudent(int i) {
		return new StudentInfo(i, names[i].first, names[i].last, 0, 0);
	}

	public static void main(String[] args) {
		new TestBinaryTree();
	}
}
