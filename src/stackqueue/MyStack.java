package stackqueue;

public class MyStack extends MyLL {

	private StudentInfo top;
	private int numInStack;

	public MyStack() {
		this.top = null;
		this.numInStack = 0;
	}

	// "sync" child class' variables with MyLL
	private void syncList() {
		this.top = super.frontOfList;
		this.numInStack = super.numInList;
	}

	public void push(StudentInfo info) {
		super.addToFront(info);
		this.syncList();
	}

	public StudentInfo pop() {
		StudentInfo res = super.removeFromFront();
		this.syncList();
		return res;
	}

	public StudentInfo peek() {
		return super.frontOfList;
	}

	public void displayStack() {
		if (super.numInList == 0) {
			System.out.println("The stack is empty...");
			return;
		}
		StudentInfo next = super.frontOfList;
		while (next != null) {
			// Print info about `next`
			System.out.println("[" + next.studentNumber + "] " + next.firstName + " " + next.lastName);

			next = next.next;
		}

		System.out.println("There is/are " + super.numInList + " student(s) in the stack.");
	}

	public StudentInfo getTop() {
		return this.top;
	}

	public int getNumInStack() {
		return this.numInStack;
	}

}
