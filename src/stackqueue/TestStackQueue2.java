package stackqueue;

public class TestStackQueue2 { // bad name haha

	public static void main(String[] args) {

		MyStack theS = new MyStack();
		MyQueue theQ = new MyQueue();

		StudentInfo someStudent, removedStudent;

// STACK
		System.out.println("\n\nStack Stuff...\n");

		theS.pop();
		theS.pop();
		theS.pop();

		System.out.println("\nAbout to display the stack (top to bottom)!");
		theS.displayStack();

		theS.pop();
		theS.pop();
		theS.pop(); // this should not blow up...

		for (int i = 1; i <= 10; i++) { // change int i to whatever but a large number means a lot more scrolling
			theS.pop();
			someStudent = new StudentInfo(i, "Daffy", "Duck", 0, 0);
			theS.push(someStudent);
			someStudent = new StudentInfo(i, "Paffy", "Duck", 0, 0);
			theS.push(someStudent);
		} // there should be only (i+1) "Daffy Duck"s left...
			// ("Paffy Duck" is always removed afterwards)

		System.out.println("\nAbout to display the stack (top to bottom)!");
		theS.displayStack();

		removedStudent = theS.pop();
		if (removedStudent == null) {
			System.out.println("\npopped item is null (a.k.a you've got problems!)");
		} else {
			System.out.println("\npopped item is " + removedStudent.firstName);
			System.out.println("attribute next has value " + removedStudent.next);
			// if removedStudent.next != null, then you've forgotten to properly detach the
			// student from the list
		}
		System.out.println("\nAbout to display the stack (top to bottom)!");
		theS.displayStack(); // there was (i+1) originally, now there should be (i) students
		System.out.println("\nthe student number of the student at the 'top' is " + theS.peek().studentNumber);
		// the student number displayed should be (i)

//		theS.push(null); // **EVIL** way to blow up this thing...

// QUEUE
		System.out.println("\n\nQueue Stuff...\n");

		theQ.dequeue();
		theQ.dequeue();
		theQ.dequeue(); // shouldn't blow up...

		System.out.println("\nAbout to display the queue (front to rear)!");
		theQ.displayQueue();

		theQ.dequeue();
		theQ.dequeue();
		theQ.dequeue(); // shouldn't blow up either...

		// the queue should be empty

		someStudent = new StudentInfo(111111, "Daffy", "Duck", 20, 10);
		theQ.enqueue(someStudent);

		for (int i = 1; i <= 10; i++) { // same thing as stack
			theQ.dequeue(); // the first dequeue should be "wasted"
			someStudent = new StudentInfo(i, "Daffy", "Duck", 0, 0);
			theQ.enqueue(someStudent);
			someStudent = new StudentInfo(i, "Paffy", "Duck", 0, 0);
			theQ.enqueue(someStudent);
		} // there should be (i+1) students in the queue; the pattern of the student
			// numbers should also be different

		System.out.println("\nAbout to display the queue (front to rear)!");
		theQ.displayQueue();

		removedStudent = theQ.dequeue();
		if (removedStudent == null) {
			System.out.println("\ndequeued item is null");
		} else {
			System.out.println("\ndequeued item is " + removedStudent.firstName);
			System.out.println("attribute next has value " + removedStudent.next);
		}

		// there should now be only (i) students
		System.out.println("\nAbout to display the queue (front to rear)!");
		theQ.displayQueue();

	} // end main

}
