package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmployeeInformationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField employeeIDTextField;

    @FXML
    private TextField employeeNameTextField;

    @FXML
    private TextField salaryTextField;

    @FXML
    private DatePicker dateOfJoiningDatePicker;

    @FXML
    private Button addButton;

    @FXML
    private Button displayAllButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField searchEmployeeTextField;

    @FXML
    private Button searchButton;

    @FXML
    private Label resultLabel;

    @FXML
    private TextArea listofEmployeesTextArea;
    
    public Repository local;
    List<Employee> list;
    
    public EmployeeInformationController() {
    	local = new Repository();
    	list = local.getRepository();
    }
    // button add new employee
    @FXML
    void addButtonClicked(ActionEvent event) { 
    	try {
    		boolean ok = true;
    		Employee employee1 = new Employee(Integer.parseInt(employeeIDTextField.getText()),employeeNameTextField.getText(),dateOfJoiningDatePicker.getValue(),Double.parseDouble(salaryTextField.getText()));
    		for (Employee emp : list) 
    		{
    			if(emp.EmployeeId == employee1.EmployeeId)
    			{
    				ok = false;
    				resultLabel.setText("Employee ID already exists");
    				break;
    			}  
    		}
    		if (ok)
    		{
    			list.add(new Employee(Integer.parseInt(employeeIDTextField.getText()),employeeNameTextField.getText(),dateOfJoiningDatePicker.getValue(),Double.parseDouble(salaryTextField.getText())));
    			resultLabel.setText("Employee added successfully");	
    		}
    	} catch (Exception e){
    		resultLabel.setText("Invalid Information");	
    	}
    }
    //button clear
	@FXML
    void clearButtonClicked(ActionEvent event) {
    	clearFields();
    }
	//button search 
	@FXML
    void searchButtonClicked(ActionEvent event) {
		if (searchEmployeeTextField.getText().isEmpty())
		{
			resultLabel.setText("Please inform the employee id or name to search");	
		} else {
			List <Employee> search = new ArrayList<>();
			try {
				int id = Integer.parseInt(searchEmployeeTextField.getText());
				for (Employee emp : list)
		    	{
		    		if (emp.EmployeeId == id)
		    		{
		    			Employee employee2 = new Employee(emp.EmployeeId, emp.EmployeeName, emp.InitialDate, emp.Salary);
		    			search.add(employee2);
		    		}
		    	}
			} catch (Exception e){
					for (Employee emp : list)
			    	{
			    		if (emp.EmployeeName.toLowerCase().contains(searchEmployeeTextField.getText().toLowerCase()))
			    		{
			    			Employee employee2 = new Employee(emp.EmployeeId, emp.EmployeeName, emp.InitialDate, emp.Salary);

			    			search.add(employee2);
			    		}
			    	}
				}
				if (search.size() > 0)
				{
					displayTextArea(search);
					resultLabel.setText("Employee exists");
				} else
				{
					clearFields();
					resultLabel.setText("Employee does not exist");	
				}
		}
    }
	//button display all
    @FXML
    void displayAllButtonClicked(ActionEvent event) {
    	displayTextArea(list);
    }
    void displayTextArea(List<Employee> list) {
    	String textArea = "EmployeeID\t\tName\t\t\tInitial Date\tSalary\n";
      	
    	for (Employee emp : list) 
    	{ 
    		textArea = textArea + emp.EmployeeId + "\t\t\t\t" + emp.EmployeeName + "\t\t\t" + emp.InitialDate + "\t" + String.format("%.2f", emp.Salary) +
    				"\n"; 
    	}
    	listofEmployeesTextArea.setText(textArea);
    }
    void clearFields() {
    	dateOfJoiningDatePicker.setValue(null);
    	employeeIDTextField.clear();
    	employeeNameTextField.clear();
    	salaryTextField.clear();
    	searchEmployeeTextField.clear();
    	listofEmployeesTextArea.clear();
    	resultLabel.setText(null);
    }
}