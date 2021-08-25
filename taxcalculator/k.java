package caseStudy;

import java.util.Scanner;

class Tax_Calculator {

	private String EmployeeNationality;
	private String Name;
	private int Salary;
	
	public Tax_Calculator(String id, String name,int salary) {
		this.EmployeeNationality= id;
		this.Name = name;
		this.Salary=salary;
		
	}
	public void setDetails(String id, String name,int salary) {
		this.EmployeeNationality= id;
		this.Name = name;
		this.Salary=salary;
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
	
	public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

       
        return true;

    }
	public static boolean num(final int n) {

        // null or empty
        if ( n <= 0) {
            return false;
        }

       
        return true;

    }
	
	public static boolean
    onlyDigits(String str) 
    { 
		int n=str.length();
        // Traverse the string from 
        // start to end 
        for (int i = 0; i < n; i++) { 
  
            // Check if character is 
            // digit from 0-9 
            // then return true 
            // else false 
            if (str.charAt(i) >= '0'
                && str.charAt(i) <= '9') { 
                return true; 
            } 
            else { 
                return false; 
            } 
        } 
        return false; 
    } 
	public static boolean
    m(String str) {
		
	String sample = str;
    char[] chars = sample.toCharArray();
    StringBuilder sb = new StringBuilder();
    for(char c : chars){
       if(Character.isDigit(c)){
          return true;
       }
    }
    return false;
    
 }
	
	public void calculateTax() {
			
		//---------------------EmployeeNationality
		if(!"Indian".equals(EmployeeNationality)||isNumeric(EmployeeNationality)==false) {
			System.out.println("CountryNotValidException"+" "+"The employee should be an Indian citizen for calculating tax.");
		System.exit(0);
		}
		else
		{
		System.out.println(this.EmployeeNationality + " "  + " "+"Valied");
		
	      
		}
		
		//------------------------Name
		if(isNumeric(Name)==false||onlyDigits(Name)==true||m(Name)==true) {
			System.out.println("EmployeeNameInvalidException"+" "+"The employee name cannot be empty or null or numeric");
		System.exit(0);
	}
		else
			System.out.println(this.Name + " "  + " "+"Valied");
		
		//------------------------Salary
		
		if(num(Salary)==false) {
			System.out.println("ValidationFailedException"+" "+" ");
		System.exit(0);
	}
		else
		{
			int p=0,r,cess;
			
			int a=12500,b=25000,c=37500,d=50000,e=62500,f=177600;
			
			
			
			if(Salary<250000) {
				System.out.println("The employee does not need to pay tax "+" "+"Your Tax amount is"+" "+"0");
				System.out.println("Thankyou for visiting KMPS....*_*");
				
			}
			
			else if(Salary>250000 && Salary<=500000) {
				
				r=Salary-250000;
				p=p+(r*5)/100;
				cess=(p*4)/100;
				System.out.println("Your cess amount :"+" "+cess);
				System.out.println("Your TOTAL TAX :"+" "+(cess+p));
				System.out.println("Thankyou for visiting KMPS....*_*");
				
				
				
			}
			else if(Salary> 500000 && Salary<=750000) {
				r=Salary-500000;
				p=p+a+(r*10/100);
				cess=(p*4)/100;
				System.out.println("Your cess amount :"+" "+cess);
				System.out.println("Your TOTAL TAX :"+" "+(cess+p));
				System.out.println("Thankyou for visiting KMPS....*_*");
				
				
			}
			else if(Salary>750000 && Salary<=1000000) {
				r=Salary-750000;
				p=p+a+b+(r*15)/100;
				cess=(p*4)/100;
				System.out.println("Your cess amount :"+" "+cess);
				System.out.println("Your TOTAL TAX :"+" "+(cess+p));
				System.out.println("Thankyou for visiting KMPS....*_*");
				
			}
			
			else if(Salary>1000000 && Salary<=1250000) {
				r=Salary-1000000;
				p=p+a+b+c+((r*20)/100);
				cess=(p*4)/100;
				System.out.println("Your cess amount :"+" "+cess);
				System.out.println("Your TOTAL TAX :"+" "+(cess+p));
				System.out.println("Thankyou for visiting KMPS....*_*");
				
			}
			else if(Salary>1250000 && Salary<=1500000) {
				r=Salary-1250000;
				p=p+a+b+c+d+(r*25)/100;
				cess=(p*4)/100;
				System.out.println("Your cess amount :"+" "+cess);
				System.out.println("Your TOTAL TAX :"+" "+(cess+p));
				System.out.println("Thankyou for visiting KMPS....*_*");
				
				
			}
			else if(Salary>1500000) {
				 r= Salary-1500000;
				p=p+a+b+c+d+e+(r*30)/100;
				cess=(p*4)/100;
				System.out.println("Your cess amount :"+" "+cess);
				System.out.println("Your TOTAL TAX :"+" "+(cess+p));
				System.out.println("Thankyou for visiting KMPS....*_*");
			}
			
		}
		
	}
}

public class CalculatorSimulator {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the number of Employees");
		int num = scnr.nextInt();
		scnr.nextLine();
		

		Tax_Calculator[] myarr = new Tax_Calculator[num];

		Class.forName("com.mysql.jdbc.Driver");
		// create connection
		Connection con = DriverManager.getConnection("jdbc.mysql://localhost:3306/shweta","root","root");
		// create statement
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
			System.out.println("Enter Your Name");
			String name = scnr.nextLine();
			System.out.println("Enter Your Salary");
			int salary = scnr.nextInt();
			
			myarr[i] = new Tax_Calculator(id, name,salary);
			
			int res = inputdata();  // insert data into the db
			if(res == 1){
				System.out.println("Data saved successfully");
						}
			else{
					System.out.println("Error! please enter the values again");
				return;
						}
			// save the data into the database
		}


		for(int j = 0; j < myarr.length; j++) {
			myarr[j].calculateTax();
		}

		// close connection
		con.close();
	}

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
}
