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
		System.out.println();

	}

	private StudentInfo newStudent(int i) {
		return new StudentInfo(i, names[i].first, names[i].last, 0, 0);
	}

	public static void main(String[] args) {
		new TestBinaryTree();
	}
}
