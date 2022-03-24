package lilian_nishimaru_exercise1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class DentalPaymentController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField addressTextField;
    
    @FXML
    private ComboBox <String> provinceComboBox;

    @FXML
    private RadioButton seniorRadioButton;

    @FXML
    private ToggleGroup discountCategory;

    @FXML
    private RadioButton kidsRadioButton;

    @FXML
    private RadioButton adultRadioButton;

    @FXML
    private CheckBox flossingCheckBox;

    @FXML
    private CheckBox fillingCheckBox;

    @FXML
    private CheckBox rootCanalCheckBox;

    @FXML
    private Button calculateButton;

    @FXML
    private Label resultLabel;
    @FXML
    void initialize() {
    	provinceComboBox.getItems().addAll("Alberta","Ontario","Quebec");
    }

    @FXML
    void CalculateClicked(ActionEvent event) {
    	
    	String message = ValidateInput();
    	
    	if (message != null)
    	{
    		resultLabel.setText(message);
    	} 
    	else {
    		//verify the services selected
        	double total = 0;
        	boolean isSelected = flossingCheckBox.isSelected();
        	if (isSelected) {
        		total = total + 20;
        	}
        	
        	isSelected = fillingCheckBox.isSelected();
        	if(isSelected) {
        		total = total + 75;
        	}
        	
        	isSelected = rootCanalCheckBox.isSelected();
        	if(isSelected) {
        		total = total + 150;
        	}
        	
        	//calculate the discount
        	
        	isSelected = seniorRadioButton.isSelected();
        	if (isSelected) {
        		total = total * 0.9;
        	}
        	isSelected = kidsRadioButton.isSelected();
        	if (isSelected) {
        		total = total * 0.85;
        	}
        
        	//calculate HST
        	double tax = 0;
        	String index = null;
        	
        		index = provinceComboBox.getValue(); 
        		switch(index) {
          	  		case "Alberta":
          	  			tax = 0.07;
          	  			break;
          	  		case "Ontario":
          	  			tax = 0.13;
          	  			break;
          	  		case "Quebec":
          	  			tax = 0.06;
          	  			break;
        		}
        
        	
        
        		total = total * (1+tax);
            	
            	//assign the result to the result label
            	String result = "Your total is $" + String.format("%.2f", total);
            	resultLabel.setText(result);

    	}
    }
    private String ValidateInput() {
    	String message = null;
    	if (nameTextField.getText().isEmpty())
    	{
    		message = "Please inform the patient's name";
    	} else 
    	{
    		if (addressTextField.getText().isEmpty())
    		{
    		message = "Please inform the patient's address";
    		} else {
    			
    			try {
    				if (provinceComboBox.getValue().isEmpty())  
    	    		{
    	    			message = "Please select a province";
    	    		}	
    	    		} catch (Exception e){
    	    			message = "Please select a province";
    	    		}
    		}
    		if (message == null)
    		{
    			boolean isFlossing  = flossingCheckBox.isSelected();
    	    	boolean isFilling   = fillingCheckBox.isSelected();
    	    	boolean isRootCanal = rootCanalCheckBox.isSelected();
    	    	if(!isFlossing && !isFilling && !isRootCanal) {
    	    		message = "Please Select at least one service";
    	    	}
    		}
    	} 		
    	return message;
    }

}
