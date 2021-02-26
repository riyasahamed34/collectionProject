import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.ideas2it.employeeProject.model.Employee;

/**
 * EmployeeManagement for Doing Crud Operation
 *
 * @version  2.0 25-02-2021
 * @author  Riyas Ahamed
 */ 
public class EmployeeManagement {
    static Scanner scanner = new Scanner(System.in);
    Map<Integer, Employee> employeeData = new HashMap<Integer, Employee>();
    
    public static void main(String[] args) {
	int menuOption = 0;
	int employeeId = 1;
	EmployeeManagement employeeObject = new EmployeeManagement();
			
	while (menuOption != 6 && menuOption < 6) {
	    System.out.println("Enter the Options");
	    System.out.println(" 1.Create a NewEmployee " +
		    "\n 2.update the existing Employee" +
		    "\n 3.show employee details \n 4.Delete the employee data" +
		    "\n 5.showALL \n 6.Exit");
	    menuOption = scanner.nextInt();
		
	    //Choosing the options		
	    switch(menuOption) {
		 case 1:		
		     employeeObject.addNewDetails(employeeId);
		     System.out.println("your employee Id is " + employeeId);
		     employeeId++;
		     break;	
		 case 2:
		     System.out.println("Enter the employee Id  to update the details" );
	             employeeId = scanner.nextInt();
	             employeeObject.updateDetails(employeeId) ;
	             break;
		 case 3:
		     System.out.println("Enter the Employee Id");
	             employeeId = scanner.nextInt();
	             employeeObject.showDetails(employeeId);
		     break;
		 case 4:
		     System.out.println("Enter the Employee Id");
	             employeeId = scanner.nextInt();
	             employeeObject.deleteDetails(employeeId);
	             break;
		 case 5:
		     employeeObject.showAll();
		     break;
	         case 6:
		     System.out.println("Thank you");
		     break;
		 default:
		     System.out.println("Enter a valid option");
		     break;
	    }
        }	
    }
	
    /**
     * Creating New Employee and details
     */
    void addNewDetails(int employeeId) {
    	System.out.println("Enter firstName");
        String firstName = scanner.next();
        System.out.println("Enter lastName");
        String lastName = scanner.next();
        scanner.nextLine();
        System.out.println("Salary");
        int salary = scanner.nextInt();
        System.out.println("Mobile Number");
        long mobileNo = scanner.nextLong();        
        employeeData.put(employeeId, new Employee(employeeId, firstName, lastName, salary, mobileNo));     
    }
    
    /**
     * Updating the Existing Employee and details
     */	
    void updateDetails(int employeeId) {

    	if(employeeData.containsKey(employeeId ) ) {
    	    System.out.println("Enter firstName");
            String firstName = scanner.next();
            System.out.println("Enter lastName");
            String lastName = scanner.next();
            scanner.nextLine();
            System.out.println("Salary");
            int salary = scanner.nextInt();
            System.out.println("Mobile Number");
            long mobileNo = scanner.nextLong();        
            employeeData.put(employeeId, new Employee (employeeId, firstName, lastName, salary, mobileNo));     
        } else {
            System.out.println("There is no such Employee Id. Please check the Id ");
        }
    }
    
    void showDetails(int employeeId) {
    	System.out.println(employeeData.get(employeeId));	
    }
    
    void deleteDetails(int employeeId) {
    	employeeData.remove(employeeId);	
    }
    
    void showAll() {

    	if (employeeData.isEmpty() ) {
            System.out.println("No Records found");
        } else {
            Iterator<Employee> iterator = employeeData.values().iterator();
            while (iterator.hasNext()) {
        	System.out.println(iterator.next());
            }	
        }	
    }
}



