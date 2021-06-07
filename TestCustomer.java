package application;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import application.Customers.CustomerType;

class Customers {
private String name;
private String email;
private String password;
private CustomerType type;
private double amount;
private Date dob;
static SimpleDateFormat sdf;
static {
	sdf= new SimpleDateFormat("dd-MM-yyyy");
}
enum CustomerType{
	SILVER,GOLD,PLATINUM;
}
public Customers(String name,String email,String password,CustomerType type,double amount,Date dob) {
	super();
	this.name=name;
	this.email=email;
	this.password=password;
	this.type=type;
	this.amount=amount;
	this.dob=dob;
}
	@Override 
	public String toString() {
		return "Name: "+ name+"email: "+email+"password: "+password+"Customer Type: "+type+"Amount: "+amount+"Date:"+ sdf.format(dob) ;
	}	
}

@SuppressWarnings("serial")
class CustomerHandlingexception extends Exception{
	public CustomerHandlingexception(String message) {
		super(message);
	}
}



 public class TestCustomer{
	 public static String validateEmail(String email) throws CustomerHandlingexception {
			if(email.contains("@") && email.endsWith(".com"))
			return email;
			throw new CustomerHandlingexception("invalid email");

		}
	 public static CustType validatType(String type) {
			return CustType.valueOf(type.toUpperCase());// if constant not found:jvm will throw illeligalexception
		}
	 public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in)){
			boolean flag =true;
			Customers[] c=new Customers[5];
			while(flag=true) {
			
			System.out.println("Enter your choice \n 1. for adding customer \n 2. displaying all customer");
			try {
			switch (sc.nextInt()) {
			case 1:
				int counter=0;
				if(counter<c.length) {
				System.out.println("Enter your name, email, password, Customer type, amount,dateofBirth");
				Customers cust=new Customers(sc.next(), validateEmail(sc.next()),sc.next(), CustomerType.valueOf(sc.next()), sc.nextDouble(), Customers.sdf.parse(sc.next()));
			c[counter++]=cust;
				}
				break;
			case 2:
				for(Customers cust:c) {
					if(cust!=null)
					System.out.println(cust);
				}
				break;
			case 3:
				flag=false;
				break;
			}	
		}catch (Exception e) {
			System.out.println(e);
		}
		}
			sc.nextLine();
			}
		
 }}