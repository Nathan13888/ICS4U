package myll;

public class MyLL {

	// defaults to null
	private StudentInfo frontOfList;
	private int numInList; // length

	public MyLL() {
		this.frontOfList = null;
		this.numInList = 0;
	}

	public void addToFront(StudentInfo nextFront) {
		nextFront.next = this.frontOfList;
		this.frontOfList = nextFront;
		numInList++;
	}

	public void addToBack(StudentInfo newBack) {
		StudentInfo last = this.frontOfList;
		if (last == null) {
			this.frontOfList = newBack;
			return;
		}
		// walk to the end first...
		while (last.next != null) {
			last = last.next;
		}
		last.next = newBack;
		numInList++;
	}

	public void addToIndex(StudentInfo student, int i) {

	}

	public StudentInfo removeFromFront() {
		StudentInfo i = this.frontOfList;
		if (i != null) {
			this.frontOfList = i.next;
			i.next = null;
			numInList--;
		}
		return i;
	}

	public StudentInfo removeFromBack() {
		StudentInfo last = this.frontOfList;
		if (last != null) {
			StudentInfo secondLast = null;
			while (last.next != null) {
				secondLast = last;
				last = last.next;
			}
			if (secondLast != null) {
				secondLast.next = null;
			}
			numInList--;
		}
		return last;
	}

	public StudentInfo removeFromIndex(int i) { // a "lazier" method would use numInList
		StudentInfo last = this.frontOfList;
		int cur = 0;
		if (last != null) {
			StudentInfo secondLast = null;
			while (last.next != null && cur < i) {
				secondLast = last;
				last = last.next;
				cur++;
			}
			if (cur != i) {
				return null;
			}
			if (secondLast != null) {
				secondLast.next = last.next;
			}
			numInList--;
		}
		return last;
	}

	public void displayList() {
		if (numInList == 0) {
			System.out.println("The list is empty...");
			return;
		}
		StudentInfo next = this.frontOfList;
		while (next != null) {
			// Print info about `next`
			System.out.println("The student number is " + next.studentNumber);
			System.out.println("The first name is " + next.firstName);
			System.out.println("The last name is " + next.lastName);
			System.out.println("The height is " + next.height);
			System.out.println("The weight is " + next.weight);
			System.out.println("The BMI is " + next.calcBMI());
			System.out.println();

			next = next.next;
		}

		System.out.println("There are " + this.numInList + " items in the list.");
	}

	public StudentInfo getFrontOfList() {
		return frontOfList;
	}

	public int getNumInList() {
		return numInList;
	}

}
