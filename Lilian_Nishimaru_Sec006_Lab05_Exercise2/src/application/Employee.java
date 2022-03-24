package application;
import java.time.LocalDate;

public class Employee {

	public int EmployeeId;
	public String EmployeeName;
	public LocalDate InitialDate;
	public double Salary;
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public LocalDate getInitialDate() {
		return InitialDate;
	}
	public void setInitialDate(LocalDate initialDate) {
		InitialDate = initialDate;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public Employee(int employeeId, String employeeName, LocalDate initialDate, double salary) {
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		InitialDate = initialDate;
		Salary = salary;
	}
	
	@Override
	public String toString() {
		return String.format("%s%d%s%s%s%s%s%.2f","EmployeeId=", EmployeeId, " EmployeeName=" , EmployeeName , " InitialDate=" , InitialDate
				, " Salary=" , Salary);
	}
	
}
