package stackqueue;

public class StudentInfo {

	// Linked List
	public StudentInfo next;

	// Attributes

	public int studentNumber;
	public String firstName;
	public String lastName;
	public double height; // in metres
	public double weight; // in kg

	// Constructors

	public StudentInfo() {
		this(-1, "Foghorn", "Leghorn", -1, -1);
	}

	public StudentInfo(int sN, String firstName, String lastName, double h, double w) {

		studentNumber = sN;
		this.firstName = firstName;
		this.lastName = lastName;
		height = h;
		weight = w;

		// Linked List 2
		this.next = null;

	}

	// Methods

	public double calcBMI() {
		/*
		 * double theBMI = weight / (height * height); return theBMI;
		 */
		return (weight / (height * height));
	}

	public void doSomething(String myStr) {
		System.out.println("hi there " + myStr);
	}

}
