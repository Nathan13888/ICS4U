package feb11.studentInfo;

public class StudentInfo {

	// Attributes

	public int studentNumber;
	public String firstName;
	public String lastName;

	// Constructors

	public StudentInfo() {
		studentNumber = -1;
		firstName = "Foghorn";
		lastName = "Leghorn";
	}

	public StudentInfo(int sN, String firstName, String lastName) {

		studentNumber = sN;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	// Methods

}
