package hashtable;

public class EmployeeInfo {

	protected int empNumber;
	protected String firstName;
	protected String lastName;
	protected int gender, workLocation;
	// gender: 0 (male), 1 (female), 2 (other)
	// workLocation: 0 (mississauga), 1 (ottawa), 2 (chicago)
	protected double deductionsRate; // decimal percentage

//	public EmployeeInfo() {
//		this(-1, "a", "aaa", 0, 0, 0.0);
//	}

	public EmployeeInfo(int eN, String fN, String lN, int g, int wL, double dR) {
		this.empNumber = eN;
		this.firstName = fN;
		this.lastName = lN;
		this.gender = g;
		this.workLocation = wL;
		this.deductionsRate = dR;
	}

	public double calcAnnualGrossIncome() {
		return 0;
	}
}
