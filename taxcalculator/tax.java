import java.util.Scanner;
import java.sql.*;

Class Calculator{


}

Class taxCalculator extends Calculator{

public double calculateTax() {
//---------------------EmployeeNationality
		if(!"Indian".equals(EmployeeNationality)||isNumeric(EmployeeNationality)==false) {
			System.out.println("CountryNotValidException"+" "+"The employee should be an Indian citizen for calculating tax.");
			return 0.0;
		}
			
		// else
		// System.out.println(this.EmployeeNationality + " "  + " "+"Valid");
		
		//------------------------Name
		if(isNumeric(Name)==false||onlyDigits(Name)==true||m(Name)==true){
			System.out.println("EmployeeNameInvalidException"+" "+"The employee name cannot be empty or null or numeric");
			return 0.0;
		}

		// else
		// 	System.out.println(this.Name + " "  + " "+"Valid");
		
		//------------------------Salary
		
		if(num(Salary)==false) {
			System.out.println("ValidationFailedException"+" "+" ");
			return 0.0;
		}
		
		else             // tax calculation
			{
			int p = 0,r,q;
			if(Salary == 250000) {
				System.out.println("The employee does not need to pay tax "+" "+"Your Tax amount is"+" "+"0");
				System.out.println("Thankyou for visiting KMPS....*_*");
			}
			
			else if(Salary>250000 && Salary<=500000) {
				
				r =500000-250000;
				p=p+(r*5)/100;
				
				System.out.println("Amount: "+" "+p);
				q=(p*4)/100;
				System.out.println("Your cess amount :"+" "+q);
				// System.out.println("Your TOTAL TAX :"+" "+q);
				return q;
				}
			else if(Salary> 500000 && Salary<=750000) {
				r=750000-500000;
				p=p+(r*10)/100;
				System.out.println("amount is"+" "+p);
				q=(p*4)/100;
				System.out.println("Your cess amount :"+" "+q);
				System.out.println("Your TOTAL TAX :"+" "+q);
				return q;				
			}
			else if(Salary>750000 && Salary<=1000000) {
				r=1000000-750000;
				p=p+(r*15)/100;
				System.out.println("amount is"+" "+p);
				q=(p*4)/100;
				System.out.println("Your cess amount :"+" "+q);
				System.out.println("Your TOTAL TAX :"+" "+q);
				return q;				
			}
			else if(Salary>1000000 && Salary<=1250000) {
				r=1250000-1000000;
				p=p+(r*20)/100;
				System.out.println("amount is"+" "+p);
				q=(p*4)/100;
				System.out.println("Your cess amount :"+" "+q);
				System.out.println("Your TOTAL TAX :"+" "+q);
				return q;
			}
			else if(Salary>1250000 && Salary<=1500000) {
				r=1500000-1250000;
				p=p+(r*25)/100;
				System.out.println("amount is"+" "+p);
				q=(p*4)/100;
				System.out.println("Your cess amount :"+" "+q);
				System.out.println("Your TOTAL TAX :"+" "+q);
				return q;								
			}
			else if(Salary>1500000) {
				r= 2092000-1500000;
				p=p+(r*30)/100;
				System.out.println("amount is"+" "+p);
				q=(p*4)/100;
				System.out.println("Your cess amount :"+" "+q);
				System.out.println("Your TOTAL TAX :"+" "+q);
				return q;
			}   // else if
}  // else

}   // calculateTax()
}  // taxCalculator

Class bonusCalculator extends Calculator{

double bonus;
	void display()
	{
		//bonus upto ₹2,50,000 --> 0%
		if (salary < 250000)
			bonus = 0;
		
		//bonus for ₹2,50,000 to ₹5,00,000 --> 0.5%
		else if (salary >= 250000 && salary < 500000)
		{
			bonus = salary * 0.5/100;
			salary = salary + bonus;
}
		
		//bonus for ₹5,00,000 to ₹7,50,000 --> 1%
			else if (salary >= 500000 && salary < 750000)
			{
				bonus = salary * 1/100;
				salary = salary + bonus;
			}
		
		//bonus for ₹7,50,000 to ₹10,00,000 --> 1.5%
			else if (salary >= 750000 && salary < 1000000)
			{
				bonus = salary * 1.5/100;
				salary = salary + bonus;
			}
		
		//bonus for ₹10,00,000 to ₹12,50,000 --> 2%
			else if (salary >= 1000000 && salary < 1250000)
			{
				bonus = salary * 2/100;
				salary = salary + bonus;
			}
		
		//bonus for ₹12,50,000 to ₹15,00,000 --> 2.5%
			else if (salary >= 1250000 && salary < 1500000)
			{
				bonus = salary * 2.5/100;
				salary = salary + bonus;
			}
		
		//bonus for more than ₹15,00,000 --> 3%
			else
			{
				bonus = salary * 3/100;
				salary = salary + bonus;
			}
		
System.out.println("Bonus = "+bonus);
		System.out.println("Salary after bonus = "+salary);
	}
}

class Trainee {             // class for validation

	private String EmployeeNationality;
	private String Name;
	private int Salary;
	private int age;
	private String profile;
	
	public Trainee(String id, String name,int salary,int age, String profile) {  // constructor
		this.EmployeeNationality= id;
		this.Name = name;
		this.Salary=salary;	
		this.age = age;
		this.profile = profile;	
	}
	
	public String getID() {
		return this.EmployeeNationality;
	}
	public String getName() {
		return this.Name;
	}
	public int getSalary() {
		return this.Salary;
	}
	public String getAge() {
		return this.age;
	}
	public int getProfile() {
		return this.profile;
	}

}

public class CalculatorSimulator extends taxCalculator{

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the number of Employees");
		int num = scnr.nextInt();
		scnr.nextLine();
		
		Trainee[] myarr = new Trainee[num];
		Class.forName("com.mysql.jdbc.Driver");
		// create connection
		Connection con = DriverManager.getConnection("jdbc.mysql://localhost:3306/shweta","root","root");
		Statement stmt = con.createStatement();

		// table creation  -- to be executed only once
		try{
		String sql = "create table Employee (name varchar(20), id varchar(20), salary integer, age integer, profile varchar(30))";
		stmt.execute(sql);
			}
		catch(Exception e){
			System.out.println(e);
			}
		
		for(int i = 0; i < num; i++) {
			System.out.println("Enter Your Nationality");
			String id = scnr.nextLine();
			scnr.nextLine();
			System.out.println("Enter Your Name");
			String name = scnr.nextLine();
			System.out.println("Enter Your Age");
			int age = scnr.nextLine();
			System.out.println("Enter Your Profile");
			String profile = scnr.nextLine();
			System.out.println("Enter Your Salary");
			String salary = scnr.nextLine();
			// to check all the values are not null, there is no code
			
			myarr[i] = new Trainee(id, name,salary, age, profile);  // Trainee object created
			// saving the data into Database

			int res = inputdata();

			if(res == 1){
				System.out.println("Data saved successfully");
						}
			else{
					System.out.println("Error! please enter the values again");
				return;
						}
		}  // for loop

		for(int j = 0; j < myarr.length; j++) {
			double tax = myarr[j].calculateTax();        // calculate tax for each trainee
			System.out.println("Tax amount is: " + tax);
			System.out.println("Thankyou for visiting KMPS");
		}   // for

		// to print whole data uncomment following lines
		// ResultSet rs = stmt.executeQuery("select * from Employee");
		// if (rs != null) {
  //           while (rs.next())  
  //           {  
  //               System.out.println(rs.getString(1));  
  //               System.out.println(rs.getString(2));  
  //               System.out.println(rs.getString(3));  
  //               System.out.println(rs.getString(4));  
  //               System.out.println(rs.getString(5));
  //           }   // while
  //           }   // if  
		stmt.close();
		con.close();

	}       // main()

public int inputdata(){
	int res = 0;
	try{
		//create statement
		Statement stmt = con.createStatement();
		String sql = "insert into employee" + "values(name, id, salary, age, profile)";
		stmt.executeUpdate(sql);
		res = 1;
		}
	catch(Exception e)
		{
			System.out.println(e);
			res = 0;
		}
	finally{
		return res;
		}
	}   // inputdata()
}   // CalculatorSimulator 