package feb11.studentInfo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * StudentInfo someStudent = new StudentInfo();
		 */
		// StudentInfo someStudent = new StudentInfo(222222, "Daffy", "Duck");
		StudentInfo someStudent = new StudentInfo();
		System.out.println("The ref val for someStudent is " + someStudent);

		System.out.println("The student number is " + someStudent.studentNumber);
		System.out.println("The first name is " + someStudent.firstName);
		System.out.println("The last name is " + someStudent.lastName + "\n");

		someStudent.studentNumber = 111111;
		someStudent.firstName = "Bugs";
		someStudent.lastName = "Bunny";

		System.out.println("The student number is " + someStudent.studentNumber);
		System.out.println("The first name is " + someStudent.firstName);
		System.out.println("The last name is " + someStudent.lastName + "\n");

		StudentInfo someOtherStudent = new StudentInfo(222222, "Daffy", "Duck");

		System.out.println("The student number is " + someOtherStudent.studentNumber);
		System.out.println("The first name is " + someOtherStudent.firstName);
		System.out.println("The last name is " + someOtherStudent.lastName + "\n");

		someStudent = someOtherStudent;
		System.out.println("someStudent now has studentNumber " + someStudent.studentNumber);

	}

}
