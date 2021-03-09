package hashtable;

public class PartTimeEmployee extends EmployeeInfo {

	private double hourlyWage, hoursPerWeek, weeksPerYear;

	// for testing
	public PartTimeEmployee(int eN) {
		this(eN, "first", "last", 0, 0, 0.05, 20.0, 45.0, 50.0);
	}

	public PartTimeEmployee(int eN, String fN, String lN, int g, int wL, double dR, double wage, double hpw,
			double wpy) {
		super(eN, fN, lN, g, wL, dR);
		this.hourlyWage = wage;
		this.hoursPerWeek = hpw;
		this.weeksPerYear = wpy;
	}

	@Override
	public double calcAnnualGrossIncome() {
		return (hourlyWage * hoursPerWeek * weeksPerYear) * (1 - deductionsRate);
	}
}
