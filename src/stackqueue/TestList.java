package stackqueue;

public class TestList {

	public static void main(String[] args) {
		MyLL ll;
		StudentInfo student;

		ll = new MyLL();
		for (int i = 0; i < 10; i += 2) {
			student = new StudentInfo(i, "first", "last", 1, 1);
			ll.addToFront(student);
			student = new StudentInfo(i + 1, "first", "last", 1, 1);
			ll.addToBack(student);
		}
		ll.displayList();
		System.out.println("\n\n...");
		System.out.println(ll.getFrontOfList());
		System.out.println("...\n\n");

//		ll = new MyLL();
//		for (int i = 0; i < 10; i += 2) {
//			System.out.println(ll.getNumInList());
//			System.out.println(ll.removeFromBack());
//			System.out.println(ll.getNumInList());
//			System.out.println(ll.removeFromFront());
//		}
//		System.out.println(ll.getNumInList());
//		ll.displayList();

		System.out.println(ll.removeFromIndex(100));
		System.out.println(ll.removeFromIndex(0));
		System.out.println(ll.removeFromIndex(1));
		System.out.println(ll.removeFromIndex(5));
		System.out.println(ll.removeFromIndex(5));
		System.out.println(ll.removeFromIndex(10));

		System.out.println(ll.removeFromFront());
		System.out.println(ll.removeFromBack());
		ll.displayList();

//		ll = new MyLL();
//		for (int i = 1; i <= 2000000; i++) {
//			student = new StudentInfo(i, "a", "aa", 1, 1);
//			ll.addToFront(student);
//		}
		ll.displayList();
	}
}
