package stackqueue;

public class MyQueue extends MyLL {

	private StudentInfo front;
	private int numInQueue;

	public MyQueue() { // could alternatively run syncList();
		this.front = null;
		this.numInQueue = 0;
	}

	// "sync" child class' variables with MyLL
	private void syncList() {
		this.front = super.frontOfList;
		this.numInQueue = super.numInList;
	}

	public void enqueue(StudentInfo info) {
		super.addToBack(info);
		this.syncList(); // actually only this.numInQueue is updated
	}

	public StudentInfo dequeue() {
		StudentInfo res = super.removeFromFront();
		this.syncList();
		return res;
	}

	public void displayQueue() {
		if (super.numInList == 0) {
			System.out.println("The queue is empty...");
			return;
		}
		StudentInfo next = super.frontOfList;
		while (next != null) {
			// Print info about `next`
			System.out.println("[" + next.studentNumber + "] " + next.firstName + " " + next.lastName);

			next = next.next;
		}

		System.out.println("There is/are " + super.numInList + " student(s) in the queue.");
	}

	public StudentInfo getFront() {
		return this.front;
	}

	public int getNumInQueue() {
		return this.numInQueue;
	}
}
