package hashtable;

public class FullTimeEmployee extends EmployeeInfo {

	protected double yearlySalary;

	public FullTimeEmployee(int eN, String fN, String lN, int g, int wL, double dR, double sal) {
		super(eN, fN, lN, g, wL, dR);
		this.yearlySalary = sal;
	}

	@Override
	public double calcAnnualGrossIncome() {
		return yearlySalary * (1 - deductionsRate);
	}
}
