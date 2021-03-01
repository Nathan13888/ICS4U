package binarytree;

public class StudentInfo {

	// Attributes

	public int studentNumber;
	public String firstName;
	public String lastName;
	public double height; // in metres
	public double weight; // in kg

	// Constructors

	public StudentInfo() {
		studentNumber = -1;
		firstName = "Foghorn";
		lastName = "Leghorn";
		height = -1.0;
		weight = -1.0;
	}

	public StudentInfo(int sN, String firstName, String lastName, double h, double w) {

		studentNumber = sN;
		this.firstName = firstName;
		this.lastName = lastName;
		height = h;
		weight = w;

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
