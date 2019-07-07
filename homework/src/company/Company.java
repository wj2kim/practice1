package company;

public class Company {
	
	private double salary;
	private double annualIncome;
	private double afterTaxIncome;
	private double bonus;
	private double afterTaxBonus;
	
	public Company() {
	
	}

	public Company(double salary) {
		super();
		this.salary = salary;
	}

	public double getAnnualIncome() {
		annualIncome=salary*12;
		return annualIncome;
	}

	public double getAfterTaxIncome() {
		afterTaxIncome=annualIncome*(1-0.1);
		return afterTaxIncome;
	}

	public double getBonus() {
		bonus=salary*0.2;
		return bonus;
	}

	public double getAfterTaxBonus() {
		afterTaxBonus=bonus*(1-0.055);
		return afterTaxBonus;
	}

	
	
	
}
