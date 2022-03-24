package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repository {
	
	public List<Employee> repository;
	
	public Repository() {
		repository = new ArrayList<Employee>();
		repository.add(new Employee(100,"Alana", LocalDate.parse("2019-10-23"),5000.00));
		repository.add(new Employee(101,"Chelsea", LocalDate.parse("2010-03-10"),4200.00));
		repository.add(new Employee(102,"Pascal", LocalDate.parse("2017-05-04"),6000.20));
		repository.add(new Employee(103,"Kyle L", LocalDate.parse("2009-12-01"),5500.15));
		repository.add(new Employee(104,"Fred V", LocalDate.parse("2009-12-01"),3500.40));
	}

	public List<Employee> getRepository() {
		return repository;
	}

}
